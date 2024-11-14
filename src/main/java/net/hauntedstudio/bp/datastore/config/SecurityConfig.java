package net.hauntedstudio.bp.datastore.config;

import net.hauntedstudio.bp.datastore.filter.TokenAuthenticationFilter;
import net.hauntedstudio.bp.datastore.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private final TokenService tokenService;

    public SecurityConfig(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for stateless APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/apiext/player_statuses/common_params",
                                "/apiext/player_statuses/map_travel",
                                "/apiext/imagine/param_level",
                                "/apiext/imagine/perk_pick",
                                "/apiext/imagine/recepi",
                                "/apiext/texts",
                                "/apiext/dungeon_entry_condition",
                                "/apiext/master_image_path",
                                "/apiext/leveldata",
                                "/apiext/master_weapon_killer_perk_pick",
                                "/apiext/player_statuses",
                                "/apiext/imagine",
                                "/apiext/items",
                                "/apiext/weapons",
                                "/apiext/master_buff",
                                "/apiext/weapon_status_levels",
                                "/apiext/master_item_efficacy",
                                "/apiext/texts?locale=ja_JP",
                                "/apiext/texts",
                                "/apiext/weaponperks",
                                "/apiext/master_weapon_perk_lotteries",
                                "/apiext/initializeweapons",
                                "/apiext/perks",
                                "/apiext/master_weapon_perk_picks",
                                "/apiext/quests",
                                "/apiext/warppoints",
                                "/apiext/texts?locale=ja_JP",
                                "/apiext/shopitems",
                                "/apiext/masterdungeonprocess",
                                "/apiext/enemyparams",
                                "/apiext/master_enemy_pt_alt",
                                "/apiext/stamps",
                                "/apiext/achievements",
                                "/apiext/ng_words",
                                "/apiext/adventurer_rank",
                                "/apiext/emotes",
                                "/apiext/craft",
                                "/apiext/treasures",
                                "/apiext/imagine",
                                "/apiext/master_recipe_release_condition",
                                "/apiext/mount",
                                "/apiext/attack_data",
                                "/apiext/attack_override_data",
                                "/apiext/skill_data",
                                "/apiext/master_attack_modifier_data",
                                "/apiext/costume",
                                "/apiext/liquid_memory_accumulate_lottery_table",
                                "/apiext/liquid_memory",
                                "/apiext/master_liquid_memory_accumulate_with_token",
                                "/apiext/master_game_modes",
                                "/apiext/maps",
                                "/apiext/master_sublevel",
                                "/apiext/token",
                                "/apiext/token_use",
                                "/apiext/supply",
                                "/apiext/event_terms",
                                "/apiext/rewards",
                                "/apiext/dungeon_rewards",
                                "/apiext/dungeon_ranked_rewards",
                                "/apiext/digital_signage",
                                "/apiext/buff_data",
                                "/apiext/master_reward_lottery_groups",
                                "/apiext/aesthe_part",
                                "/apiext/aesthe_course",
                                "/apiext/master_costume_extras",
                                "/apiext/master_aesthe_restrictions",
                                "/apiext/guild_rank",
                                "/apiext/guild_rank_reward",
                                "/apiext/shop",
                                "/apiext/payment_limit",
                                "/apiext/shop_purchase_condition",
                                "/apiext/shop_item_set",
                                "/apiext/shop_realmoney_item",
                                "/apiext/currency_shop",
                                "/apiext/currency_shop_purchase_limit",
                                "/apiext/coin_shop",
                                "/apiext/coin_shop_purchase_limit",
                                "/apiext/master_season_pass_shop",
                                "/apiext/coin_exchange",
                                "/apiext/master_season_pass_shop_purchase_limit",
                                "/apiext/item_box",
                                "/apiext/master_season_pass",
                                "/apiext/master_season",
                                "/apiext/master_season_pass_reward",
                                "/apiext/master_warehouse_ability_recipes",
                                "/apiext/master_warehouse_collection_abilities",
                                "/apiext/master_warehouse_storing_abilities",
                                "/apiext/master_warehouse_mission_abilities",
                                "/apiext/master_warehouse_production_abilities",
                                "/apiext/master_warehouse_zone_abilities",
                                "/apiext/master_mission_boost_abilities",
                                "/apiext/master_warehouse_token_abilities",
                                "/apiext/master_liquid_memory_boost_abilities",
                                "/apiext/master_stackboost_boost_abilities",
                                "/apiext/master_mount_expedition_boost_abilities",
                                "/apiext/master_followup_team",
                                "/apiext/master_raid_settings",
                                "/apiext/equipment_condition_set",
                                "/apiext/master_challenge_quest",
                                "/apiext/master_challenge_quest_destructible_objects",
                                "/apiext/craft_token",
                                "/apiext/master_merchandise_counter",
                                "/apiext/master_merchandise_commodity",
                                "/apiext/master_merchandise_item_set",
                                "/apiext/master_real_goods",
                                "/apiext/master_battle_score_settings",
                                "/apiext/master_battle_score_weapon_effect",
                                "/apiext/master_coupon",
                                "/apiext/master_network_cafe_buffs",
                                "/apiext/master_event_enemy_drop",
                                "/apiext/master_event_challengequest_drop",
                                "/apiext/master_craft_recipe_sets",
                                "/apiext/master_adventure_board",
                                "/apiext/master_adventure_board_panel",
                                "/apiext/master_adventure_board_quest",
                                "/apiext/country_config",
                                "/apiext/master_fusion_item",
                                "/apiext/master_fusion_ability_effect_pickup",
                                "/apiext/master_version",
                                "/apiext/master_ranking_rewards",
                                "/apiext/master_feature_setting",
                                "/apiext/master_nappos",
                                "/apiext/master_dxbattle_contribution_score_coefficients",
                                "/apiext/master_dxbattle_contribution_score_attenuations",
                                "/apiext/master_imagine_paramadd_bystackboosts",
                                "/apiext/master_weapon_statusadd_bystackboosts",
                                "/apiext/master_stackboosts",
                                "/apiext/master_stackboost_tickets",
                                "/apiext/master_imagine_hyoui_ability_patterns",
                                "/apiext/master_equipment_series",
                                "/apiext/master_sub_class_bonuses",
                                "/apiext/master_fusion_cost",
                                "/apiext/master_fusion_ticket",
                                "/apiext/master_weapon_fusion_cost_adjustment",
                                "/apiext/master_ornaments",
                                "/apiext/master_mount_expedition_add_reward_count",
                                "/apiext/master_game_settings",
                                "/apiext/master_awards",
                                "/apiext/master_adventure_card_decoration",
                                "/apiext/master_mount_expedition_tokens",
                                "/apiext/master_rooms",
                                "/apiext/master_room_puts",
                                "/apiext/master_help_matching_mode",
                                "/apiext/master_help_matching_rewards",
                                "/apiext/master_help_matching_required_battle_score",
                                "/apiext/mission_entry_condition_set",
                                "/apiext/master_event",
                                "/apiext/master_event_map",
                                "/apiext/master_event_rewards",
                                "/apiext/master_event_guild_rewards",
                                "/apiext/master_upload_image",
                                "/apiext/master_take_apart",
                                "/apiext/master_main_ability_tickets",
                                "/apiext/master_enhance_imagine_ability_tickets",
                                "/apiext/master_player_tag",
                                "/apiext/login_launcher"
                        )
                        .permitAll() // Allow access to static resources and public routes
                        .anyRequest().authenticated() // Protect all other endpoints
                )
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No sessions
                )
                .addFilterBefore(new TokenAuthenticationFilter(tokenService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}