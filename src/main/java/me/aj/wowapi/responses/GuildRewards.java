package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class GuildRewards extends AbstractResponse {

    @Getter
    private List<Reward> rewards;

    @Override
    public RequestType getRequestType() {
        return RequestType.GUILD_REWARDS;
    }

    @Getter
    public class Reward {
        private Integer minGuildLevel;
        private Integer minGuildRepLevel;
        private CharacterAchievements.AchievementInfo achievement;
        private Item item;
        private List<Integer> races;
    }

    @Getter
    public class Item {
        private Integer id;
        private String name;
        private String icon;
        private Integer quality;
        private Integer itemLevel;
        private CharacterAchievements.TooltipParams tooltipParams;
        private List<Object> stats;
        private Integer armor;
        private String context;
        private List<Object> bonusLists;
    }
}
