package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class BattleGroups extends AbstractResponse {

    @Getter
    private List<BattleGroup> battlegroups;

    @Override
    public RequestType getRequestType() {
        return RequestType.BATTLEGROUPS;
    }

    public class BattleGroup {
        @Getter
        private String name, slug;
    }
}
