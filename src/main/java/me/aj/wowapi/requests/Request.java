package me.aj.wowapi.requests;

import com.sun.deploy.util.StringUtils;
import lombok.Getter;
import me.aj.wowapi.WoWAPI;

import java.util.LinkedHashMap;
import java.util.List;


@Getter
public class Request {

    private RequestType requestType;
    private final LinkedHashMap<RequestType.ParamType, String> params;
    private final List<String> fields;
    private String queryURL;

    /**
     * @param requestType Request type to receive a response.
     * @param params The parameters in this query
     * @param fields Optional - Used for more data
     */
    Request(RequestType requestType, LinkedHashMap<RequestType.ParamType, String> params, List<String> fields) {
        this.params = params;
        this.fields = fields;
        this.requestType = requestType;

        /// Format: wow/...DIR...?locale
        if (params.size() == 0) {
            this.queryURL = WoWAPI.URL_PREFIX + requestType.getDir() + WoWAPI.get().getURLSuffix();
        } else {
            this.queryURL = WoWAPI.URL_PREFIX + requestType.getDir();
            //Add Params
            for (String value : params.values()) {
                queryURL = queryURL.concat(value + "/");
            }
            queryURL = removeSlash(queryURL);
            //Check Fields
            if (fields.size() > 0) {
                queryURL = queryURL.concat("?fields=" + StringUtils.join(fields, ",") + "&" + WoWAPI.get().getURLSuffix().substring(1));
            } else {
                queryURL = queryURL.concat(WoWAPI.get().getURLSuffix());
            }
        }
    }

    /**
     * Remove the end "/" of a string
     * @param str the query/string
     */
    private String removeSlash(String str) {
        return str.substring(0, str.length() - 1);
    }
}