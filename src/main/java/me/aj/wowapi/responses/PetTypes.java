package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class PetTypes extends AbstractResponse {

    @Getter
    private List<PetType> petTypes;

    @Override
    public RequestType getRequestType() {
        return RequestType.PET_TYPES;
    }

    @Getter
    public class PetType {
        private Integer id;
        private String key;
        private String name;
        private Integer typeAbilityId;
        private Integer strongAgainstId;
        private Integer weakAgainstId;
    }
}
