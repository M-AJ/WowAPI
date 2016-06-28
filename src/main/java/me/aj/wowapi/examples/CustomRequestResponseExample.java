package me.aj.wowapi.examples;

import lombok.Getter;
import me.aj.wowapi.WoWAPI;
import me.aj.wowapi.requests.Request;
import me.aj.wowapi.requests.RequestBuilder;
import me.aj.wowapi.requests.RequestType;
import me.aj.wowapi.responses.AbstractResponse;

public class CustomRequestResponseExample {

    /**
     * Get a request with a custom field and object that is not in this library
     * We make this method synchronized because multiple threads
     * can edit the CUSTOM request type
     */
    public synchronized void customRequest(){
        RequestType custom = RequestType.CUSTOM;
        custom.setDir("quest/");
        custom.setParams(new RequestType.ParamType[]{RequestType.ParamType.QUEST_ID});
        custom.setResponseClass(MyQuestResponse.class);

        Request questRequest = RequestBuilder
                .create()
                .request(custom)
                .param(RequestType.ParamType.QUEST_ID, "13146")
                .build();

        try {
            MyQuestResponse response = WoWAPI.get().getRequesteDataSync(questRequest);
            System.out.print("\nCategory: " + response.getCategory() + " Title: " + response.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Getter
    private class MyQuestResponse extends AbstractResponse {
        private int id;
        private String title;
        private int reqLevel;
        private int suggestedPartyMembers;
        private String category;
        private int level;

        @Override
        public RequestType getRequestType() {
            return RequestType.CUSTOM;
        }
    }
}
