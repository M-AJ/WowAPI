package me.aj.wowapi.examples;

import me.aj.wowapi.WoWAPI;
import me.aj.wowapi.requests.Request;
import me.aj.wowapi.requests.RequestBuilder;
import me.aj.wowapi.requests.RequestType;
import me.aj.wowapi.responses.BattleGroups;
import me.aj.wowapi.util.Callback;

public class AsyncRequestExample {

    /**
     * Get a request async
     */
    public void requestAsync(){
        //Get all battle groups
        Request request = RequestBuilder
                .create()
                .request(RequestType.BATTLEGROUPS)
                .build();

        //Use the BattleGroups decode class
        WoWAPI.get().getRequestDataAsync(request, new Callback<BattleGroups>() {
            @Override
            public void call(Throwable throwable, BattleGroups battleGroups) {
                for(BattleGroups.BattleGroup group : battleGroups.getBattlegroups()){
                    System.out.print("\nName: " + group.getName() + " Slug: " + group.getSlug());
                }
            }
        });
    }
}
