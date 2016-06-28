package me.aj.wowapi.responses;

import me.aj.wowapi.requests.RequestType;


public abstract class AbstractResponse {

    /**
     * The type of request this response object is encoded from
     */
    public abstract RequestType getRequestType();

}
