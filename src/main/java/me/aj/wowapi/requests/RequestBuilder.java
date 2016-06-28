package me.aj.wowapi.requests;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import me.aj.wowapi.exceptions.RequestIncompleteException;

import java.util.LinkedHashMap;
import java.util.List;

public class RequestBuilder {

    private RequestType requestType;
    private LinkedHashMap<RequestType.ParamType, String> params = Maps.newLinkedHashMap();
    private List<String> fields = Lists.newArrayList();

    /**
     * New empty instance. Building after this will throw an exception
     * Must have the request type inputed
     * @return An instance of this class to add to the request
     */
    public static RequestBuilder create() {
        return new RequestBuilder();
    }

    /**
     * Set the request type
     * @return An instance of this class to add to the request
     */
    public RequestBuilder request(RequestType type) {
        this.requestType = type;
        return this;
    }

    /**
     * Add a parameter
     * @return An instance of this class to add to the request
     */
    public RequestBuilder param(RequestType.ParamType param, String value) {
        params.put(param, value);
        return this;
    }

    /**
     * Add the optional fields
     * @return An instance of this class to add to the request
     */
    public RequestBuilder fields(String... fields){
        this.fields = Lists.newArrayList(fields);
        return this;
    }

    /**
     * Build the instance
     * @return Request An instance of this the Reqest class
     */
    public Request build() {
        if (isComplete()) {
            return new Request(requestType, params, fields);
        }
        throw new RequestIncompleteException();
    }

    /**
     * Check if the request is in good shape
     * @return If the necessary info is set
     */
    private boolean isComplete() {
        boolean typeComplete = requestType != null;
        if (!typeComplete) {
            return false;
        }
        return requestType.getParams().length == params.size();
    }
}
