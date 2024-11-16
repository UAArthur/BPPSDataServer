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
        String baseUrl = "https://masterdata-main.aws.blue-protocol.com/apiext/";
        endpointsMap.put("items", baseUrl + "items?t=1731461273");
        endpointsMap.put("weapons", baseUrl + "weapons?t=1731461346");
        endpointsMap.put("master_buff", baseUrl + "master_buff?t=1731461311");
        endpointsMap.put("player_statuses", baseUrl + "player_statuses?t=1731461341");
        endpointsMap.put("weapon_status_levels", baseUrl + "weapon_status_levels?t=1731461340");
        endpointsMap.put("master_item_efficacy", baseUrl + "item_efficacy?t=1731461325");
        endpointsMap.put("weaponperks", baseUrl + "weaponperks?t=1731461346");
        endpointsMap.put("master_weapon_perk_lotteries", baseUrl + "master_weapon_perk_lotteries?t=1731461337");
        endpointsMap.put("initializeweapons", baseUrl + "initializeweapons?t=1731461271");
        endpointsMap.put("perks", baseUrl + "perks?t=1731461341");
        endpointsMap.put("master_weapon_perk_picks", baseUrl + "master_weapon_perk_picks?t=1731461337");
        endpointsMap.put("quests", baseUrl + "quests?t=1731461345");
        endpointsMap.put("warppoints", baseUrl + "warppoints?t=1731461345");
        endpointsMap.put("texts", baseUrl + "texts/ja_JP?t=1731461263");
        endpointsMap.put("shopitems", baseUrl + "shopitems?t=1731461345");
        endpointsMap.put("masterdungeonprocess", baseUrl + "master_dungeon_process?t=1731461269");
        endpointsMap.put("enemyparams", baseUrl + "enemyparams?t=1731461270");
        endpointsMap.put("master_enemy_pt_alt", baseUrl + "master_enemy_pt_alt?t=1731461315");
        endpointsMap.put("stamps", baseUrl + "master_stamp_category?t=1731461334");
        endpointsMap.put("achievements", baseUrl + "achievements?t=1731461267");
        endpointsMap.put("ng_words", baseUrl + "ng_words?t=1700618657");
        endpointsMap.put("adventurer_rank", baseUrl + "adventurer_rank?t=1731461276");
        endpointsMap.put("emotes", baseUrl + "emotes?t=1731461315");
        endpointsMap.put("craft", baseUrl + "craft?t=1731461351");
        endpointsMap.put("treasures", baseUrl + "treasures?t=1731461336");
        endpointsMap.put("imagine", baseUrl + "imagine?t=1731461319");
        endpointsMap.put("master_recipe_release_condition", baseUrl + "masterrecipereleasecondition?t=1731461331");
        endpointsMap.put("mount", baseUrl + "mount?t=1731461328");
        endpointsMap.put("attack_data", baseUrl + "attack_data?t=1731461278");
        endpointsMap.put("attack_override_data", baseUrl + "attack_override_data?t=1731461279");
        endpointsMap.put("skill_data", baseUrl + "skill_data?t=1731461334");
        endpointsMap.put("master_attack_modifier_data", baseUrl + "master_attack_modifier_data?t=1731461278");
        endpointsMap.put("costume", baseUrl + "costume?t=1731461268");
        endpointsMap.put("liquid_memory_accumulate_lottery_table", baseUrl + "liquid_memory_accumulate_lottery_table?t=1731461326");
        endpointsMap.put("liquid_memory", baseUrl + "liquid_memory?t=1731461325");
        endpointsMap.put("master_liquid_memory_accumulate_with_token", baseUrl + "master_liquid_memory_accumulate_with_token?t=1731461326");
        endpointsMap.put("master_game_modes", baseUrl + "master_game_modes?t=1731461271");
        endpointsMap.put("maps", baseUrl + "maps?t=1731461273");
        endpointsMap.put("master_sublevel", baseUrl + "master_sublevels?t=1731461335");
        endpointsMap.put("token", baseUrl + "token?t=1731461335");
        endpointsMap.put("token_use", baseUrl + "token_use?t=1731461336");
        endpointsMap.put("supply", baseUrl + "supply?t=1731461335");
        endpointsMap.put("event_terms", baseUrl + "event_term?t=1730253389");
        endpointsMap.put("rewards", baseUrl + "rewards?t=1731461353");
        endpointsMap.put("dungeon_rewards", baseUrl + "dungeon_rewards?t=1731461355");
        endpointsMap.put("dungeon_ranked_rewards", baseUrl + "dungeon_ranked_rewards?t=1731461353");
        endpointsMap.put("digital_signage", baseUrl + "digital_signage?t=1722994303");
        endpointsMap.put("buff_data", baseUrl + "freebuff?t=1731461316");
        endpointsMap.put("master_reward_lottery_groups", baseUrl + "master_reward_lottery_groups?t=1731461358");
        endpointsMap.put("aesthe_part", baseUrl + "aestheParts?t=1731461276");
        endpointsMap.put("aesthe_course", baseUrl + "aestheCourse?t=1731461276");
        endpointsMap.put("master_costume_extras", baseUrl + "buffPlacement?t=1731461312");
        endpointsMap.put("master_aesthe_restrictions", baseUrl + "master_aesthe_restrictions?t=1731461276");
        endpointsMap.put("guild_rank", baseUrl + "guild_rank?t=1731461318");
        endpointsMap.put("guild_rank_reward", baseUrl + "guild_rank_reward?t=1731461355");
        endpointsMap.put("shop", baseUrl + "shop?t=1731461331");
        endpointsMap.put("payment_limit", baseUrl + "payment_limit?t=1731461329");
        endpointsMap.put("shop_purchase_condition", baseUrl + "shop_purchase_condition?t=1731461333");
        endpointsMap.put("shop_item_set", baseUrl + "shop_item_set?t=1731461333");
        endpointsMap.put("shop_realmoney_item", baseUrl + "shop_realmoney_item?t=1731461334");
        endpointsMap.put("currency_shop", baseUrl + "currency_shop?t=1731461313");
        endpointsMap.put("currency_shop_purchase_limit", baseUrl + "currency_shop_purchase_limit?t=1731461313");
        endpointsMap.put("coin_shop", baseUrl + "coin_shop?t=1731461312");
        endpointsMap.put("coin_shop_purchase_limit", baseUrl + "coin_shop_purchase_limit?t=1731461312");
        endpointsMap.put("master_season_pass_shop", baseUrl + "master_season_pass_shops?t=1731461331");
        endpointsMap.put("coin_exchange", baseUrl + "coin_exchange?t=1731461312");
        endpointsMap.put("master_season_pass_shop_purchase_limit", baseUrl + "master_season_pass_shop_purchase_limits?t=1731461331");
        endpointsMap.put("item_box", baseUrl + "item_box?t=1731461325");
        endpointsMap.put("master_season_pass", baseUrl + "master_season_pass?t=1731461331");
        endpointsMap.put("master_season", baseUrl + "master_season?t=1731461331");
        endpointsMap.put("master_season_pass_reward", baseUrl + "master_season_pass_reward?t=1731461358");
        endpointsMap.put("master_warehouse_ability_recipes", baseUrl + "master_warehouse_ability_recipes?t=1731461336");
        endpointsMap.put("master_warehouse_collection_abilities", baseUrl + "master_warehouse_collection_abilities?t=1731461336");
        endpointsMap.put("master_warehouse_storing_abilities", baseUrl + "master_warehouse_storing_abilities?t=1731461337");
        endpointsMap.put("master_warehouse_mission_abilities", baseUrl + "master_warehouse_mission_abilities?t=1731461336");
        endpointsMap.put("master_warehouse_production_abilities", baseUrl + "master_warehouse_production_abilities?t=1731461337");
        endpointsMap.put("master_warehouse_zone_abilities", baseUrl + "master_warehouse_zone_abilities?t=1731461337");
        endpointsMap.put("master_mission_boost_abilities", baseUrl + "master_mission_boost_abilities?t=1731461328");
        endpointsMap.put("master_warehouse_token_abilities", baseUrl + "master_warehouse_token_abilities?t=1731461337");
        endpointsMap.put("master_liquid_memory_boost_abilities", baseUrl + "master_liquid_memory_boost_abilities?t=1731461326");
        endpointsMap.put("master_stackboost_boost_abilities", baseUrl + "master_stackboost_abilities?t=1731461334");
        endpointsMap.put("master_mount_expedition_boost_abilities", baseUrl + "master_mount_expedition_boost_abilities?t=1731461328");
        endpointsMap.put("master_followup_team", baseUrl + "masterfollowupteam?t=1731461316");
        endpointsMap.put("master_raid_settings", baseUrl + "master_raid_settings?t=1731461330");
        endpointsMap.put("equipment_condition_set", baseUrl + "equipment_condition_set?t=1731461315");
        endpointsMap.put("master_challenge_quest", baseUrl + "masterchallengequest?t=1731461311");
        endpointsMap.put("master_challenge_quest_destructible_objects", baseUrl + "master_challenge_quest_destructible_objects?t=1731461311");
        endpointsMap.put("craft_token", baseUrl + "craft_token?t=1731461313");
        endpointsMap.put("master_merchandise_counter", baseUrl + "master_merchandise_counter?t=1731461327");
        endpointsMap.put("master_merchandise_commodity", baseUrl + "master_merchandise_commodity?t=1731461327");
        endpointsMap.put("master_merchandise_item_set", baseUrl + "master_merchandise_item_set?t=1731461327");
        endpointsMap.put("master_real_goods", baseUrl + "master_real_goods?t=1731461331");
        endpointsMap.put("master_battle_score_settings", baseUrl + "master_battle_score_settings?t=1731461310");
        endpointsMap.put("master_battle_score_weapon_effect", baseUrl + "master_battle_score_weapon_effect?t=1731461310");
        endpointsMap.put("master_coupon", baseUrl + "coupon?t=1731461312");
        endpointsMap.put("master_network_cafe_buffs", baseUrl + "master_network_cafe_buffs?t=1731461328");
        endpointsMap.put("master_event_enemy_drop", baseUrl + "event_enemy_drop?t=1731461316");
        endpointsMap.put("master_event_challengequest_drop", baseUrl + "master_event_challengequest_drop?t=1731461315");
        endpointsMap.put("master_craft_recipe_sets", baseUrl + "master_craft_recipe_sets?t=1731461313");
        endpointsMap.put("master_adventure_board", baseUrl + "master_adventure_board?t=1731461275");
        endpointsMap.put("master_adventure_board_panel", baseUrl + "master_adventure_board_panel?t=1731461274");
        endpointsMap.put("master_adventure_board_quest", baseUrl + "master_adventure_board_quest?t=1731461275");
        endpointsMap.put("country_config", baseUrl + "country_config?t=1731461312");
        endpointsMap.put("master_fusion_item", baseUrl + "master_fusion_item?t=1731461317");
        endpointsMap.put("master_fusion_ability_effect_pickup", baseUrl + "master_fusion_ability_effect_pickup?t=1731461317");
        endpointsMap.put("master_version", baseUrl + "master_version?t=1731461266");
        endpointsMap.put("master_ranking_rewards", baseUrl + "master_ranking_rewards?t=1731461356");
        endpointsMap.put("master_feature_setting", baseUrl + "master_feature_setting?t=1731461316");
        endpointsMap.put("master_nappos", baseUrl + "master_nappos?t=1731461328");
        endpointsMap.put("master_dxbattle_contribution_score_coefficients", baseUrl + "master_dxbattle_contribution_score_coefficients?t=1731461315");
        endpointsMap.put("master_dxbattle_contribution_score_attenuations", baseUrl + "master_dxbattle_contribution_score_attenuations?t=1731461315");
        endpointsMap.put("master_imagine_paramadd_bystackboosts", baseUrl + "master_imagine_paramadd_bystackboosts?t=1731461324");
        endpointsMap.put("master_weapon_statusadd_bystackboosts", baseUrl + "master_weapon_statusadd_bystackboosts?t=1731461340");
        endpointsMap.put("master_stackboosts", baseUrl + "master_stackboost?t=1731461334");
        endpointsMap.put("master_stackboost_tickets", baseUrl + "master_stackboost_tickets?t=1731461334");
        endpointsMap.put("master_imagine_hyoui_ability_patterns", baseUrl + "master_imagine_hyoui_ability_patterns?t=1731461319");
        endpointsMap.put("master_equipment_series", baseUrl + "master_equipment_series?t=1731461315");
        endpointsMap.put("master_sub_class_bonuses", baseUrl + "master_sub_class_bonuses?t=1731461334");
        endpointsMap.put("master_fusion_cost", baseUrl + "master_fusion_cost?t=1731461317");
        endpointsMap.put("master_fusion_ticket", baseUrl + "master_fusion_ticket?t=1731461317");
        endpointsMap.put("master_weapon_fusion_cost_adjustment", baseUrl + "master_weapon_fusion_cost_adjustment?t=1731461337");
        endpointsMap.put("master_ornaments", baseUrl + "master_ornaments?t=1731461329");
        endpointsMap.put("master_mount_expedition_add_reward_count", baseUrl + "master_mount_expedition_add_reward_count?t=1731461355");
        endpointsMap.put("master_game_settings", baseUrl + "master_game_settings?t=1731461317");
        endpointsMap.put("master_awards", baseUrl + "award?t=1731461279");
        endpointsMap.put("master_adventure_card_decoration", baseUrl + "master_adventure_card_decoration?t=1731461275");
        endpointsMap.put("master_mount_expedition_tokens", baseUrl + "master_mount_expedition_tokens?t=1731461328");
        endpointsMap.put("master_rooms", baseUrl + "master_rooms?t=1731461331");
        endpointsMap.put("master_room_puts", baseUrl + "master_room_puts?t=1731461331");
        endpointsMap.put("master_help_matching_mode", baseUrl + "help_matching_mode?t=1731461319");
        endpointsMap.put("master_help_matching_rewards", baseUrl + "help_matching_rewards?t=1731461319");
        endpointsMap.put("master_help_matching_required_battle_score", baseUrl + "help_matching_required_battle_score?t=1731461319");
        endpointsMap.put("mission_entry_condition_set", baseUrl + "mission_entry_condition_set?t=1731461328");
        endpointsMap.put("master_event", baseUrl + "event?t=1731461315");
        endpointsMap.put("master_event_map", baseUrl + "event_map?t=1731461316");
        endpointsMap.put("master_event_rewards", baseUrl + "event_rewards?t=1731461316");
        endpointsMap.put("master_event_guild_rewards", baseUrl + "event_guild_rewards?t=1731461316");
        endpointsMap.put("master_upload_image", baseUrl + "master_upload_image?t=1731461336");
        endpointsMap.put("master_take_apart", baseUrl + "master_take_apart?t=1731461335");
        endpointsMap.put("master_main_ability_tickets", baseUrl + "master_main_ability_tickets?t=1731461326");
        endpointsMap.put("master_enhance_imagine_ability_tickets", baseUrl + "master_enhance_imagine_ability_tickets?t=1731461315");
        endpointsMap.put("master_player_tag", baseUrl + "master_player_tag?t=1731461329");
        endpointsMap.put("imagine/param_level", baseUrl + "imagine/param_level?t=1731461323");
        endpointsMap.put("imagine/perk_pick", baseUrl + "imagine/perk_pick?t=1731461325");
        endpointsMap.put("imagine/recepi", baseUrl + "imagine/recepi?t=1731461348");
        endpointsMap.put("player_statuses/map_travel", baseUrl + "player_statuses_map_travel?t=1731461341");
        endpointsMap.put("player_statuses/common_params", baseUrl + "player_statuses_common_params?t=1731461341");
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
