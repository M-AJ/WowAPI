# WowAPI

WowAPI is the world of warcraft community api in the java implementation.

## Features:
  * Threaded request execution. Get your responses async or sync
  * Preloaded with the data resources api
  * Can't find the response your looking for? Create your own response and request objects.
  * Automated decoder and encoder, just create your custom class with the right field names!
  * Ability to query and retrieve anything that is not already in this api. 
  * Project is annotated and contains multiple examples [here](https://github.com/M-AJ/WowAPI/tree/master/src/main/java/me/aj/wowapi/examples)
  * API is thread safe!
  
This API's flexibility allows you to access any world of warcraft data at any time.

### Few Dependencies

* Apache Http Componenets
* Gson
* Lombok
* Couple More. View pom

### Installation

Add this maven lib to your project and start using the api!
There are a few examples[here](https://github.com/M-AJ/WowAPI/tree/master/src/main/java/me/aj/wowapi/examples) in the lib itself. 

```java
//Set the API Key and Locale - Necessary
WoWAPI.get().setApiAndLocale("YOUR KEY HERE", "en_US");
//Now use the WowAPI class to get requests! View examples for usage!
```

### Development
Pull requests are accepted! You can add your own responses and decoders.

### Todos

 - Optional: PR or add more responses
 - Public Maven Repo?

License
----

MIT
