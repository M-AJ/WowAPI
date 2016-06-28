package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class CharacterClasses extends AbstractResponse {

    @Getter
    private List<CharacterClass> classes;

    @Override
    public RequestType getRequestType() {
        return RequestType.CHARACTER_CLASSES;
    }

    @Getter
    public class CharacterClass {
        private int id, mask;
        private String powerType, name;
    }
}
