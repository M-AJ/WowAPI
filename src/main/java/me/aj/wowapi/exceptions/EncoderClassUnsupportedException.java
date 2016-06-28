package me.aj.wowapi.exceptions;

public class EncoderClassUnsupportedException extends RuntimeException {

    public EncoderClassUnsupportedException() {
        super("The decoding class for the json content is missing");
    }
}
