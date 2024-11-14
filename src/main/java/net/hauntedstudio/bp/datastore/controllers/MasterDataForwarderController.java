package net.hauntedstudio.bp.datastore.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/apiext")
public class MasterDataForwarderController {

    private HashMap<String, String> endpointsMap = new HashMap<>();

    public MasterDataForwarderController(){
        endpointsMap.put("items", "https://masterdata-main.aws.blue-protocol.com/apiext/items?t=1731461273");
        endpointsMap.put("weapons", "https://masterdata-main.aws.blue-protocol.com/apiext/weapons?t=1731461346");
        endpointsMap.put("master_buff", "https://masterdata-main.aws.blue-protocol.com/apiext/master_buff?t=1731461311");
        endpointsMap.put("player_statuses", "https://masterdata-main.aws.blue-protocol.com/apiext/player_statuses?t=1731461341");
        endpointsMap.put("weapon_status_levels", "https://masterdata-main.aws.blue-protocol.com/apiext/weapon_status_levels?t=1731461340");
        endpointsMap.put("master_item_efficacy", "https://masterdata-main.aws.blue-protocol.com/apiext/item_efficacy?t=1731461325");
        endpointsMap.put("weaponperks", "https://masterdata-main.aws.blue-protocol.com/apiext/weaponperks?t=1731461346");
        endpointsMap.put("master_weapon_perk_lotteries", "https://masterdata-main.aws.blue-protocol.com/apiext/master_weapon_perk_lotteries?t=1731461337");
        endpointsMap.put("initializeweapons", "https://masterdata-main.aws.blue-protocol.com/apiext/initializeweapons?t=1731461271");
        endpointsMap.put("perks", "https://masterdata-main.aws.blue-protocol.com/apiext/perks?t=1731461341");
        endpointsMap.put("master_weapon_perk_picks", "https://masterdata-main.aws.blue-protocol.com/apiext/master_weapon_perk_picks?t=1731461337");
        endpointsMap.put("quests", "https://masterdata-main.aws.blue-protocol.com/apiext/quests?t=1731461345");
        endpointsMap.put("warppoints", "https://masterdata-main.aws.blue-protocol.com/apiext/warppoints?t=1731461345");
        endpointsMap.put("texts", "https://masterdata-main.aws.blue-protocol.com/apiext/texts/ja_JP?t=1731461263");
        endpointsMap.put("shopitems", "https://masterdata-main.aws.blue-protocol.com/apiext/shopitems?t=1731461345");
        endpointsMap.put("masterdungeonprocess", "https://masterdata-main.aws.blue-protocol.com/apiext/master_dungeon_process?t=1731461269");
        endpointsMap.put("enemyparams", "https://masterdata-main.aws.blue-protocol.com/apiext/enemyparams?t=1731461270");
        endpointsMap.put("master_enemy_pt_alt", "https://masterdata-main.aws.blue-protocol.com/apiext/master_enemy_pt_alt?t=1731461315");
        endpointsMap.put("stamps", "https://masterdata-main.aws.blue-protocol.com/apiext/master_stamp_category?t=1731461334");
        endpointsMap.put("achievements", "https://masterdata-main.aws.blue-protocol.com/apiext/achievements?t=1731461267");
        endpointsMap.put("ng_words", "https://masterdata-main.aws.blue-protocol.com/apiext/ng_words?t=1700618657");
        endpointsMap.put("adventurer_rank", "https://masterdata-main.aws.blue-protocol.com/apiext/adventurer_rank?t=1731461276");
        endpointsMap.put("emotes", "https://masterdata-main.aws.blue-protocol.com/apiext/emotes?t=1731461315");
        endpointsMap.put("craft", "https://masterdata-main.aws.blue-protocol.com/apiext/craft?t=1731461351");
        endpointsMap.put("treasures", "https://masterdata-main.aws.blue-protocol.com/apiext/treasures?t=1731461336");
        endpointsMap.put("imagine", "https://masterdata-main.aws.blue-protocol.com/apiext/imagine?t=1731461319");
        endpointsMap.put("master_recipe_release_condition", "https://masterdata-main.aws.blue-protocol.com/apiext/masterrecipereleasecondition?t=1731461331");
        endpointsMap.put("mount", "https://masterdata-main.aws.blue-protocol.com/apiext/mount?t=1731461328");
        endpointsMap.put("attack_data", "https://masterdata-main.aws.blue-protocol.com/apiext/attack_data?t=1731461278");
        endpointsMap.put("attack_override_data", "https://masterdata-main.aws.blue-protocol.com/apiext/attack_override_data?t=1731461279");
        endpointsMap.put("skill_data", "https://masterdata-main.aws.blue-protocol.com/apiext/skill_data?t=1731461334");
        endpointsMap.put("master_attack_modifier_data", "https://masterdata-main.aws.blue-protocol.com/apiext/master_attack_modifier_data?t=1731461278");
        endpointsMap.put("costume", "https://masterdata-main.aws.blue-protocol.com/apiext/costume?t=1731461268");
        endpointsMap.put("liquid_memory_accumulate_lottery_table", "https://masterdata-main.aws.blue-protocol.com/apiext/liquid_memory_accumulate_lottery_table?t=1731461326");
        endpointsMap.put("liquid_memory", "https://masterdata-main.aws.blue-protocol.com/apiext/liquid_memory?t=1731461325");
        endpointsMap.put("master_liquid_memory_accumulate_with_token", "https://masterdata-main.aws.blue-protocol.com/apiext/master_liquid_memory_accumulate_with_token?t=1731461326");
        endpointsMap.put("master_game_modes", "https://masterdata-main.aws.blue-protocol.com/apiext/master_game_modes?t=1731461271");
        endpointsMap.put("maps", "https://masterdata-main.aws.blue-protocol.com/apiext/maps?t=1731461273");
        endpointsMap.put("master_sublevel", "https://masterdata-main.aws.blue-protocol.com/apiext/master_sublevels?t=1731461335");
        endpointsMap.put("token", "https://masterdata-main.aws.blue-protocol.com/apiext/token?t=1731461335");
        endpointsMap.put("token_use", "https://masterdata-main.aws.blue-protocol.com/apiext/token_use?t=1731461336");
        endpointsMap.put("supply", "https://masterdata-main.aws.blue-protocol.com/apiext/supply?t=1731461335");
        endpointsMap.put("event_terms", "https://masterdata-main.aws.blue-protocol.com/apiext/event_term?t=1730253389");
        endpointsMap.put("rewards", "https://masterdata-main.aws.blue-protocol.com/apiext/rewards?t=1731461353");
        endpointsMap.put("dungeon_rewards", "https://masterdata-main.aws.blue-protocol.com/apiext/dungeon_rewards?t=1731461355");
        endpointsMap.put("dungeon_ranked_rewards", "https://masterdata-main.aws.blue-protocol.com/apiext/dungeon_ranked_rewards?t=1731461353");
        endpointsMap.put("digital_signage", "https://masterdata-main.aws.blue-protocol.com/apiext/digital_signage?t=1722994303");
        endpointsMap.put("buff_data", "https://masterdata-main.aws.blue-protocol.com/apiext/freebuff?t=1731461316");
        endpointsMap.put("master_reward_lottery_groups", "https://masterdata-main.aws.blue-protocol.com/apiext/master_reward_lottery_groups?t=1731461358");
        endpointsMap.put("aesthe_part", "https://masterdata-main.aws.blue-protocol.com/apiext/aestheParts?t=1731461276");
        endpointsMap.put("aesthe_course", "https://masterdata-main.aws.blue-protocol.com/apiext/aestheCourse?t=1731461276");
        endpointsMap.put("master_costume_extras", "https://masterdata-main.aws.blue-protocol.com/apiext/buffPlacement?t=1731461312");
        endpointsMap.put("master_aesthe_restrictions", "https://masterdata-main.aws.blue-protocol.com/apiext/master_aesthe_restrictions?t=1731461276");
        endpointsMap.put("guild_rank", "https://masterdata-main.aws.blue-protocol.com/apiext/guild_rank?t=1731461318");
        endpointsMap.put("guild_rank_reward", "https://masterdata-main.aws.blue-protocol.com/apiext/guild_rank_reward?t=1731461355");
        endpointsMap.put("shop", "https://masterdata-main.aws.blue-protocol.com/apiext/shop?t=1731461331");
        endpointsMap.put("payment_limit", "https://masterdata-main.aws.blue-protocol.com/apiext/payment_limit?t=1731461329");
        endpointsMap.put("shop_purchase_condition", "https://masterdata-main.aws.blue-protocol.com/apiext/shop_purchase_condition?t=1731461333");
        endpointsMap.put("shop_item_set", "https://masterdata-main.aws.blue-protocol.com/apiext/shop_item_set?t=1731461333");
        endpointsMap.put("shop_realmoney_item", "https://masterdata-main.aws.blue-protocol.com/apiext/shop_realmoney_item?t=1731461334");
        endpointsMap.put("currency_shop", "https://masterdata-main.aws.blue-protocol.com/apiext/currency_shop?t=1731461313");
        endpointsMap.put("currency_shop_purchase_limit", "https://masterdata-main.aws.blue-protocol.com/apiext/currency_shop_purchase_limit?t=1731461313");
        endpointsMap.put("coin_shop", "https://masterdata-main.aws.blue-protocol.com/apiext/coin_shop?t=1731461312");
        endpointsMap.put("coin_shop_purchase_limit", "https://masterdata-main.aws.blue-protocol.com/apiext/coin_shop_purchase_limit?t=1731461312");
        endpointsMap.put("master_season_pass_shop", "https://masterdata-main.aws.blue-protocol.com/apiext/master_season_pass_shops?t=1731461331");
        endpointsMap.put("coin_exchange", "https://masterdata-main.aws.blue-protocol.com/apiext/coin_exchange?t=1731461312");
        endpointsMap.put("master_season_pass_shop_purchase_limit", "https://masterdata-main.aws.blue-protocol.com/apiext/master_season_pass_shop_purchase_limits?t=1731461331");
        endpointsMap.put("item_box", "https://masterdata-main.aws.blue-protocol.com/apiext/item_box?t=1731461325");
        endpointsMap.put("master_season_pass", "https://masterdata-main.aws.blue-protocol.com/apiext/master_season_pass?t=1731461331");
        endpointsMap.put("master_season", "https://masterdata-main.aws.blue-protocol.com/apiext/master_season?t=1731461331");
        endpointsMap.put("master_season_pass_reward", "https://masterdata-main.aws.blue-protocol.com/apiext/master_season_pass_reward?t=1731461358");
        endpointsMap.put("master_warehouse_ability_recipes", "https://masterdata-main.aws.blue-protocol.com/apiext/master_warehouse_ability_recipes?t=1731461336");
        endpointsMap.put("master_warehouse_collection_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_warehouse_collection_abilities?t=1731461336");
        endpointsMap.put("master_warehouse_storing_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_warehouse_storing_abilities?t=1731461337");
        endpointsMap.put("master_warehouse_mission_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_warehouse_mission_abilities?t=1731461336");
        endpointsMap.put("master_warehouse_production_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_warehouse_production_abilities?t=1731461337");
        endpointsMap.put("master_warehouse_zone_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_warehouse_zone_abilities?t=1731461337");
        endpointsMap.put("master_mission_boost_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_mission_boost_abilities?t=1731461328");
        endpointsMap.put("master_warehouse_token_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_warehouse_token_abilities?t=1731461337");
        endpointsMap.put("master_liquid_memory_boost_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_liquid_memory_boost_abilities?t=1731461326");
        endpointsMap.put("master_stackboost_boost_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_stackboost_abilities?t=1731461334");
        endpointsMap.put("master_mount_expedition_boost_abilities", "https://masterdata-main.aws.blue-protocol.com/apiext/master_mount_expedition_boost_abilities?t=1731461328");
        endpointsMap.put("master_followup_team", "https://masterdata-main.aws.blue-protocol.com/apiext/masterfollowupteam?t=1731461316");
        endpointsMap.put("master_raid_settings", "https://masterdata-main.aws.blue-protocol.com/apiext/master_raid_settings?t=1731461330");
        endpointsMap.put("equipment_condition_set", "https://masterdata-main.aws.blue-protocol.com/apiext/equipment_condition_set?t=1731461315");
        endpointsMap.put("master_challenge_quest", "https://masterdata-main.aws.blue-protocol.com/apiext/masterchallengequest?t=1731461311");
        endpointsMap.put("master_challenge_quest_destructible_objects", "https://masterdata-main.aws.blue-protocol.com/apiext/master_challenge_quest_destructible_objects?t=1731461311");
        endpointsMap.put("craft_token", "https://masterdata-main.aws.blue-protocol.com/apiext/craft_token?t=1731461313");
        endpointsMap.put("master_merchandise_counter", "https://masterdata-main.aws.blue-protocol.com/apiext/master_merchandise_counter?t=1731461327");
        endpointsMap.put("master_merchandise_commodity", "https://masterdata-main.aws.blue-protocol.com/apiext/master_merchandise_commodity?t=1731461327");
        endpointsMap.put("master_merchandise_item_set", "https://masterdata-main.aws.blue-protocol.com/apiext/master_merchandise_item_set?t=1731461327");
        endpointsMap.put("master_real_goods", "https://masterdata-main.aws.blue-protocol.com/apiext/master_real_goods?t=1731461331");
        endpointsMap.put("master_battle_score_settings", "https://masterdata-main.aws.blue-protocol.com/apiext/master_battle_score_settings?t=1731461310");
        endpointsMap.put("master_battle_score_weapon_effect", "https://masterdata-main.aws.blue-protocol.com/apiext/master_battle_score_weapon_effect?t=1731461310");
        endpointsMap.put("master_coupon", "https://masterdata-main.aws.blue-protocol.com/apiext/coupon?t=1731461312");
        endpointsMap.put("master_network_cafe_buffs", "https://masterdata-main.aws.blue-protocol.com/apiext/master_network_cafe_buffs?t=1731461328");
        endpointsMap.put("master_event_enemy_drop", "https://masterdata-main.aws.blue-protocol.com/apiext/event_enemy_drop?t=1731461316");
        endpointsMap.put("master_event_challengequest_drop", "https://masterdata-main.aws.blue-protocol.com/apiext/master_event_challengequest_drop?t=1731461315");
        endpointsMap.put("master_craft_recipe_sets", "https://masterdata-main.aws.blue-protocol.com/apiext/master_craft_recipe_sets?t=1731461313");
        endpointsMap.put("master_adventure_board", "https://masterdata-main.aws.blue-protocol.com/apiext/master_adventure_board?t=1731461275");
        endpointsMap.put("master_adventure_board_panel", "https://masterdata-main.aws.blue-protocol.com/apiext/master_adventure_board_panel?t=1731461274");
        endpointsMap.put("master_adventure_board_quest", "https://masterdata-main.aws.blue-protocol.com/apiext/master_adventure_board_quest?t=1731461275");
        endpointsMap.put("country_config", "https://masterdata-main.aws.blue-protocol.com/apiext/country_config?t=1731461312");
        endpointsMap.put("master_fusion_item", "https://masterdata-main.aws.blue-protocol.com/apiext/master_fusion_item?t=1731461317");
        endpointsMap.put("master_fusion_ability_effect_pickup", "https://masterdata-main.aws.blue-protocol.com/apiext/master_fusion_ability_effect_pickup?t=1731461317");
        endpointsMap.put("master_version", "https://masterdata-main.aws.blue-protocol.com/apiext/master_version?t=1731461266");
        endpointsMap.put("master_ranking_rewards", "https://masterdata-main.aws.blue-protocol.com/apiext/master_ranking_rewards?t=1731461356");
        endpointsMap.put("master_feature_setting", "https://masterdata-main.aws.blue-protocol.com/apiext/master_feature_setting?t=1731461316");
        endpointsMap.put("master_nappos", "https://masterdata-main.aws.blue-protocol.com/apiext/master_nappos?t=1731461328");
        endpointsMap.put("master_dxbattle_contribution_score_coefficients", "https://masterdata-main.aws.blue-protocol.com/apiext/master_dxbattle_contribution_score_coefficients?t=1731461315");
        endpointsMap.put("master_dxbattle_contribution_score_attenuations", "https://masterdata-main.aws.blue-protocol.com/apiext/master_dxbattle_contribution_score_attenuations?t=1731461315");
        endpointsMap.put("master_imagine_paramadd_bystackboosts", "https://masterdata-main.aws.blue-protocol.com/apiext/master_imagine_paramadd_bystackboosts?t=1731461324");
        endpointsMap.put("master_weapon_statusadd_bystackboosts", "https://masterdata-main.aws.blue-protocol.com/apiext/master_weapon_statusadd_bystackboosts?t=1731461340");
        endpointsMap.put("master_stackboosts", "https://masterdata-main.aws.blue-protocol.com/apiext/master_stackboost?t=1731461334");
        endpointsMap.put("master_stackboost_tickets", "https://masterdata-main.aws.blue-protocol.com/apiext/master_stackboost_tickets?t=1731461334");
        endpointsMap.put("master_imagine_hyoui_ability_patterns", "https://masterdata-main.aws.blue-protocol.com/apiext/master_imagine_hyoui_ability_patterns?t=1731461319");
        endpointsMap.put("master_equipment_series", "https://masterdata-main.aws.blue-protocol.com/apiext/master_equipment_series?t=1731461315");
        endpointsMap.put("master_sub_class_bonuses", "https://masterdata-main.aws.blue-protocol.com/apiext/master_sub_class_bonuses?t=1731461334");
        endpointsMap.put("master_fusion_cost", "https://masterdata-main.aws.blue-protocol.com/apiext/master_fusion_cost?t=1731461317");
        endpointsMap.put("master_fusion_ticket", "https://masterdata-main.aws.blue-protocol.com/apiext/master_fusion_ticket?t=1731461317");
        endpointsMap.put("master_weapon_fusion_cost_adjustment", "https://masterdata-main.aws.blue-protocol.com/apiext/master_weapon_fusion_cost_adjustment?t=1731461337");
        endpointsMap.put("master_ornaments", "https://masterdata-main.aws.blue-protocol.com/apiext/master_ornaments?t=1731461329");
        endpointsMap.put("master_mount_expedition_add_reward_count", "https://masterdata-main.aws.blue-protocol.com/apiext/master_mount_expedition_add_reward_count?t=1731461355");
        endpointsMap.put("master_game_settings", "https://masterdata-main.aws.blue-protocol.com/apiext/master_game_settings?t=1731461317");
        endpointsMap.put("master_awards", "https://masterdata-main.aws.blue-protocol.com/apiext/award?t=1731461279");
        endpointsMap.put("master_adventure_card_decoration", "https://masterdata-main.aws.blue-protocol.com/apiext/master_adventure_card_decoration?t=1731461275");
        endpointsMap.put("master_mount_expedition_tokens", "https://masterdata-main.aws.blue-protocol.com/apiext/master_mount_expedition_tokens?t=1731461328");
        endpointsMap.put("master_rooms", "https://masterdata-main.aws.blue-protocol.com/apiext/master_rooms?t=1731461331");
        endpointsMap.put("master_room_puts", "https://masterdata-main.aws.blue-protocol.com/apiext/master_room_puts?t=1731461331");
        endpointsMap.put("master_help_matching_mode", "https://masterdata-main.aws.blue-protocol.com/apiext/help_matching_mode?t=1731461319");
        endpointsMap.put("master_help_matching_rewards", "https://masterdata-main.aws.blue-protocol.com/apiext/help_matching_rewards?t=1731461319");
        endpointsMap.put("master_help_matching_required_battle_score", "https://masterdata-main.aws.blue-protocol.com/apiext/help_matching_required_battle_score?t=1731461319");
        endpointsMap.put("mission_entry_condition_set", "https://masterdata-main.aws.blue-protocol.com/apiext/mission_entry_condition_set?t=1731461328");
        endpointsMap.put("master_event", "https://masterdata-main.aws.blue-protocol.com/apiext/event?t=1731461315");
        endpointsMap.put("master_event_map", "https://masterdata-main.aws.blue-protocol.com/apiext/event_map?t=1731461316");
        endpointsMap.put("master_event_rewards", "https://masterdata-main.aws.blue-protocol.com/apiext/event_rewards?t=1731461316");
        endpointsMap.put("master_event_guild_rewards", "https://masterdata-main.aws.blue-protocol.com/apiext/event_guild_rewards?t=1731461316");
        endpointsMap.put("master_upload_image", "https://masterdata-main.aws.blue-protocol.com/apiext/master_upload_image?t=1731461336");
        endpointsMap.put("master_take_apart", "https://masterdata-main.aws.blue-protocol.com/apiext/master_take_apart?t=1731461335");
        endpointsMap.put("master_main_ability_tickets", "https://masterdata-main.aws.blue-protocol.com/apiext/master_main_ability_tickets?t=1731461326");
        endpointsMap.put("master_enhance_imagine_ability_tickets", "https://masterdata-main.aws.blue-protocol.com/apiext/master_enhance_imagine_ability_tickets?t=1731461315");
        endpointsMap.put("master_player_tag", "https://masterdata-main.aws.blue-protocol.com/apiext/master_player_tag?t=1731461329");
        endpointsMap.put("imagine/param_level", "https://masterdata-main.aws.blue-protocol.com/apiext/imagine/param_level?t=1731461323");
        endpointsMap.put("imagine/perk_pick", "https://masterdata-main.aws.blue-protocol.com/apiext/imagine/perk_pick?t=1731461325");
        endpointsMap.put("imagine/recepi", "https://masterdata-main.aws.blue-protocol.com/apiext/imagine/recepi?t=1731461348");
        endpointsMap.put("player_statuses/map_travel", "https://masterdata-main.aws.blue-protocol.com/apiext/player_statuses_map_travel?t=1731461341");
        endpointsMap.put("player_statuses/common_params", "https://masterdata-main.aws.blue-protocol.com/apiext/player_statuses_common_params?t=1731461341");
    }

    @GetMapping("/{endpoint}")
    public String redirectToExternalEndpoint(@PathVariable String endpoint, HttpServletResponse response) throws IOException {
        String targetUrl = endpointsMap.get(endpoint);

        System.out.println("Redirecting to: " + targetUrl + " for endpoint: " + endpoint);
        if (targetUrl != null) {
            // Redirecting with a 302 status code
            response.setStatus(HttpServletResponse.SC_FOUND);
            response.setHeader("Location", targetUrl);
        } else {
            // Return a 404 if the endpoint doesn't exist in the map
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Endpoint not found");
        }
        return generateHtmlRedirect(targetUrl);
    }

    @GetMapping("/player_statuses/{endpoint}")
    public String redirectToExternalEndpointPlayerStatuses(@PathVariable String endpoint, HttpServletResponse response) throws IOException {
        String targetUrl = endpointsMap.get("player_statuses/"+endpoint);

        System.out.println("Redirecting to: " + targetUrl + " for endpoint: " + "player_statuses/" +endpoint);
        if (targetUrl != null) {
            // Redirecting with a 302 status code
            response.setStatus(HttpServletResponse.SC_FOUND);
            response.setHeader("Location", targetUrl);
        } else {
            // Return a 404 if the endpoint doesn't exist in the map
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Endpoint not found");
        }
        return generateHtmlRedirect(targetUrl);
    }

    @GetMapping("/imagine/{endpoint}")
    public String redirectToExternalEndpointImagine(@PathVariable String endpoint, HttpServletResponse response) throws IOException {
        String targetUrl = endpointsMap.get("imagine/"+endpoint);

        System.out.println("Redirecting to: " + targetUrl + " for endpoint: " + "imagine/"+endpoint);
        if (targetUrl != null) {
            // Redirecting with a 302 status code
            response.setStatus(HttpServletResponse.SC_FOUND);
            response.setHeader("Location", targetUrl);
        } else {
            // Return a 404 if the endpoint doesn't exist in the map
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Endpoint not found");
        }
        return generateHtmlRedirect(targetUrl);
    }


    public String generateHtmlRedirect(String url) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\" />\n" +
                "        <meta http-equiv=\"refresh\" content=\"0;url='" + url + "'\" />\n" +
                "        <title>Redirecting to " + url + "</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        Redirecting to <a href=\"" + url + "\">" + url + "</a>.\n" +
                "    </body>\n" +
                "</html>";
    }
}
