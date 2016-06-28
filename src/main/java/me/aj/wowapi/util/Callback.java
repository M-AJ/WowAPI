package me.aj.wowapi.util;

/**
 * @param <T> The decoder class
 */
public abstract class Callback<T> {

    /**
     * Called when the response request has been finished.
     * @param throwable If the call did not success, this is the exception
     * @param t the object that has been called. May be null
     */
    public abstract void call(Throwable throwable, T t);

}
