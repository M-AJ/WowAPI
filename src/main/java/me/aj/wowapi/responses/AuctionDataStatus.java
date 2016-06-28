package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class AuctionDataStatus extends AbstractResponse {

    @Getter
    private List<AuctionData> files;

    @Override
    public RequestType getRequestType() {
        return RequestType.AUCTION_DATA_STATUS;
    }

    @Getter
    public class AuctionData {
        private String url; //TODO parse json again?
        private long lastModified;
    }
}
