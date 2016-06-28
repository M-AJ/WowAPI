package me.aj.wowapi.examples;

import me.aj.wowapi.WoWAPI;

public class Example {

    private Example() {
        //Set the API Key and Locale - Necessary
        WoWAPI.get().setApiAndLocale("YOUR KEY HERE", "en_US");
        // Examples
            new CustomRequestResponseExample().customRequest();
            new AsyncRequestExample().requestAsync();
            new SimpleRequestExample().requestSync();
    }


    public static void main(String[] args) {
        new Example();
    }
}
