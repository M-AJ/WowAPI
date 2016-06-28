package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class ItemClasses extends AbstractResponse {

    @Getter
    private List<ItemClass> classes;

    @Override
    public RequestType getRequestType() {
        return RequestType.ITEM_CLASSES;
    }

    @Getter
    public class ItemClass {
        private String name;
        private List<Subclass> subclasses;
        //TODO Field "class" is an integer
    }

    @Getter
    public class Subclass {
        private Integer subclass;
        private String name;
    }
}
