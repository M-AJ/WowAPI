package me.aj.wowapi.responses;


import lombok.Getter;
import me.aj.wowapi.requests.RequestType;

import java.util.List;

public class CharacterAchievements extends AbstractResponse {

    @Getter
    private List<Achievement> achievements;

    @Override
    public RequestType getRequestType() {
        return RequestType.CHARACTER_ACHIEVEMENTS;
    }

    @Getter
    public class Achievement {
        private Integer id;
        private List<AchievementInfo> achievements;
        private String name;
        private List<Category> categories;
    }

    @Getter
    public class Category {
        private Integer id;
        private List<AchievementInfo> achievements;
        private String name;
    }

    @Getter
    public class AchievementInfo {
        private Integer id;
        private String title;
        private Integer points;
        private String description;
        private List<RewardItem> rewardItems;
        private String icon;
        private List<Criterium> criteria;
        private Boolean accountWide;
        private Integer factionId;
        private String reward;
    }

    @Getter
    public class Criterium {
        private Integer id;
        private String description;
        private Integer orderIndex;
        private Integer max;
    }

    @Getter
    public class RewardItem {
        private Integer id;
        private String name;
        private String icon;
        private Integer quality;
        private Integer itemLevel;
        private TooltipParams tooltipParams;
        private List<Object> stats;//TODO
        private Integer armor;
        private String context;
        private List<Object> bonusLists;//TODO
    }

    @Getter
    public class TooltipParams {
        private Integer timewalkerLevel;
    }
}
