package me.aj.wowapi.examples;

import me.aj.wowapi.WoWAPI;
import me.aj.wowapi.requests.Request;
import me.aj.wowapi.requests.RequestBuilder;
import me.aj.wowapi.requests.RequestType;
import me.aj.wowapi.responses.BattleGroups;

public class SimpleRequestExample {

    /**
     * A simple request on the current thread
     */
    public void requestSync() {
        //Get all battle groups
        Request request = RequestBuilder
                .create()
                .request(RequestType.BATTLEGROUPS)
                .build();

        //Use the BattleGroups decode class
        try {
            BattleGroups battleGroups = WoWAPI.get().getRequesteDataSync(request);
            for (BattleGroups.BattleGroup group : battleGroups.getBattlegroups()) {
                System.out.print("\nName: " + group.getName() + " Slug: " + group.getSlug());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
