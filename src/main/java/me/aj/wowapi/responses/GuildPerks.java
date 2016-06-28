package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class GuildPerks extends AbstractResponse {

    @Getter
    private List<Perk> perks;

    @Override
    public RequestType getRequestType() {
        return RequestType.GUILD_PERKS;
    }

    @Getter
    public class Perk {
        private Integer guildLevel;
        private Spell spell;
    }

    @Getter
    public class Spell {
        private Integer id;
        private String name;
        private String subtext;
        private String icon;
        private String description;
        private String castTime;
        private String cooldown;
    }
}
