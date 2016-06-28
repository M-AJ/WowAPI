package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class GuildAchievements extends AbstractResponse {

    @Getter
    private List<CharacterAchievements.Achievement> achievements;

    @Override
    public RequestType getRequestType() {
        return RequestType.GUILD_ACHIEVEMENTS;
    }
}
