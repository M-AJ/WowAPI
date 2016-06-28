package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

@Getter
public class Talents extends AbstractResponse {

    //TODO encoding has fields with ints as names

    @Override
    public RequestType getRequestType() {
        return RequestType.TALENTS;
    }
}
