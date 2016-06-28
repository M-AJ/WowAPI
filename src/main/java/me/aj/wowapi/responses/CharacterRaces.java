package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class CharacterRaces extends AbstractResponse {

    @Getter
    private List<CharacterRace> races;

    @Override
    public RequestType getRequestType() {
        return RequestType.CHARACTER_RACES;
    }

    @Getter
    public class CharacterRace {
        private int id, mask;
        private String side, name;
    }
}
