package me.aj.wowapi.exceptions;

public class RequestIncompleteException extends RuntimeException {

    public RequestIncompleteException() {
        super("Some fields were missing or incorrect in your request!");
    }
}
