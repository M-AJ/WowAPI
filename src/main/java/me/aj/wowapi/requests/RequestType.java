package me.aj.wowapi.requests;

import lombok.Getter;
import lombok.Setter;
import me.aj.wowapi.exceptions.EncoderClassUnsupportedException;
import me.aj.wowapi.responses.*;


public enum RequestType {

    //A user created request at runtime
    CUSTOM(null, null),

    //Data Resources
    BATTLEGROUPS("data/battlegroups/", BattleGroups.class),
    CHARACTER_RACES("data/character/races", CharacterRaces.class),
    CHARACTER_CLASSES("data/character/classes", CharacterClasses.class),
    CHARACTER_ACHIEVEMENTS("data/character/achievements", CharacterAchievements.class),
    GUILD_REWARDS("data/guild/rewards", GuildRewards.class),
    GUILD_PERKS("data/guild/perks", GuildPerks.class),
    GUILD_ACHIEVEMENTS("data/guild/achievements", GuildAchievements.class),
    ITEM_CLASSES("data/item/classes", ItemClasses.class),
    TALENTS("data/talents", Talents.class),
    PET_TYPES("data/pet/types", PetTypes.class),

    //Auction
    AUCTION_DATA_STATUS("auction/data/", AuctionDataStatus.class, ParamType.REALM),//TODO add option for parameters

    //Character Profile
    CHARACTER_PROFILE("character/", null, ParamType.REALM, ParamType.CHARACTER_NAME);

    //All directories will start after wow/ and end before ?locale
    //Direcotires with Params will have a / in the end
    @Getter @Setter
    private String dir;
    @Getter @Setter
    private Class<? extends AbstractResponse> responseClass;
    @Getter @Setter
    private ParamType[] params;

    RequestType(String dir, Class<? extends AbstractResponse> responseClass, ParamType... params) {
        this.dir = dir;
        this.responseClass = responseClass;
        this.params = params;
    }

    /**
     * Throws exception if the enum/custom type has invalid or missing data
     */
    public synchronized void checkReadyToEncode() {
        if (responseClass == null) {
            throw new EncoderClassUnsupportedException();
        }
    }

    public enum ParamType {
        //All Param Types will be strings
        REALM, BOSS_ID, CHARACTER_NAME, GUILD_NAME, ITEM_ID, SET_ID,
        ABILITY_ID, SPECIES_ID, BRACKET, QUEST_ID, RECIPE_ID, SPELL_ID, ZONE_ID
    }
}