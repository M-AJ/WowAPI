package me.aj.wowapi.exceptions;

public class QueryNotReadyException extends RuntimeException {

    public QueryNotReadyException() {
        super("The API or locale was not set");
    }
}
