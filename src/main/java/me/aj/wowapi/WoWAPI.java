package me.aj.wowapi;

import com.google.gson.Gson;
import lombok.Getter;
import me.aj.wowapi.exceptions.QueryNotReadyException;
import me.aj.wowapi.requests.Request;
import me.aj.wowapi.responses.AbstractResponse;
import me.aj.wowapi.util.Callback;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WoWAPI {

    public static final Logger LOGGER = Logger.getLogger("WoWAPI");
    //Only used for World of Warcraft
    public static final String URL_PREFIX = "https://us.api.battle.net/wow/";
    //Gson is used to decode data and encode it to the response objects
    private final Gson gson = new Gson();
    //Establish connection to the URL and gather the data
    private final HttpClient httpClient = HttpClientBuilder.create().build();
    //Async connections
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    //Necessary developer components
    @Getter
    private volatile String apiKey, locale;//TODO support multiple locales, make two seperate set methods?
    //Our API :D
    private static WoWAPI instance;

    private WoWAPI() {}

    /**
     * Get or create the instance of the API class.
     * @return API instance.
     */
    public static WoWAPI get() {
        return instance == null ? instance = new WoWAPI() : instance;
    }

    /**
     * Used to verify necessary info before creating a request
     * @throws QueryNotReadyException
     */
    private void checkReady() {
        if (apiKey == null || locale == null) {
            throw new QueryNotReadyException();
        }
    }

    /**
     * Get the locale and the apikey section (suffix)
     * @return The ending of the url query
     */
    public String getURLSuffix() {
        checkReady();
        return "?locale=" + locale + "&apikey=" + apiKey;
    }

    /**
     * Set the main components for the api to work.
     * You must use this method before any requests or no api calls will work
     * Synchronized because multiple threads may set locacles or apis
     * @param apiKey The key used from your battle net account
     * @param locale Ex. en_US, shows realm data in the US only, not EU, etc...
     */
    public synchronized void setApiAndLocale(String apiKey, String locale) {
        this.apiKey = apiKey;
        this.locale = locale;
        LOGGER.log(Level.INFO, "API and Locale Set!");
        //TODO verify correct api key?
    }

    /**
     * Gets the data on the current thread
     * Synchronized because multiple threads may get data at the same time using
     * @param <T> The response object that will be encoded.
     * @param request The request from RequestBuilder that is the query
     * @return The AbstractResponse. You may create your own. This will be encoded from the json
     */
    public synchronized <T extends AbstractResponse> T getRequesteDataSync(Request request) throws Exception {
        checkReady();
        request.getRequestType().checkReadyToEncode();
        HttpResponse httpResponse = httpClient.execute(new HttpGet(request.getQueryURL()));
        return gson.fromJson(EntityUtils.toString(httpResponse.getEntity(), "UTF-8"),
                (Class<T>) request.getRequestType().getResponseClass());
    }

    /**
     * Gets the data returned into a callback on a seperate thread
     * Synchronized because multiple threads may get data at the same time using
     * Overloaded method
     * @param <T> The response object that will be encoded.
     * @param request The request from RequestBuilder that is the query
     * @param callback The callback called on another thread when the data response is complete
     */
    public synchronized <T extends AbstractResponse> void getRequestDataAsync(Request request, Callback<T> callback) {
        executorService.submit(() -> getRequestData(request, callback));
    }

    /**
     * Gets the data on the current thread with a callback. Used for overloaded methods
     * Not Synchronized because only impl of this is the async method which is already thread safe
     * @param request The request from RequestBuilder that is the query
     * @param callback The callback called on same thread when the data response is complete
     */
    private <T extends AbstractResponse> void getRequestData(Request request, Callback<T> callback) {
        checkReady();
        request.getRequestType().checkReadyToEncode();
        try {
            httpClient.execute(new HttpGet(request.getQueryURL()), httpResponse -> {
                T result;
                try {
                    result = gson.fromJson(EntityUtils.toString(httpResponse.getEntity(), "UTF-8"),
                            (Class<T>) request.getRequestType().getResponseClass());
                } catch (Exception e) {
                    callback.call(e, null);
                    return null;
                }
                callback.call(null, result);
                return httpResponse;
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
