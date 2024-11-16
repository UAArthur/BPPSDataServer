package net.hauntedstudio.bp.datastore.controllers.auth;

//Controller handles everything related to authentication

import com.google.gson.JsonObject;
import net.hauntedstudio.bp.datastore.entity.CharacterSlotEntity;
import net.hauntedstudio.bp.datastore.entity.PlayerEntity;
import net.hauntedstudio.bp.datastore.entity.UserEntity;
import net.hauntedstudio.bp.datastore.entity.Users;
import net.hauntedstudio.bp.datastore.request.auth.LoginLauncherRequest;
import net.hauntedstudio.bp.datastore.response.auth.LoginLauncherResponse;
import net.hauntedstudio.bp.datastore.response.users.OptionResponse;
import net.hauntedstudio.bp.datastore.response.users.PersonalNewResponse;
import net.hauntedstudio.bp.datastore.response.users.lci.LastContentInfoResponse;
import net.hauntedstudio.bp.datastore.services.TokenService;
import net.hauntedstudio.bp.datastore.services.user.CharacterSlotService;
import net.hauntedstudio.bp.datastore.services.user.PlayerService;
import net.hauntedstudio.bp.datastore.services.user.UserService;
import net.hauntedstudio.bp.datastore.services.user.UsersService;
import net.hauntedstudio.bp.datastore.utils.RequestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/apiext")
public class AuthenticationController {

    private final TokenService tokenService;

    private final UserService userService;

    private final UsersService usersService;

    private final PlayerService playerService;

    private final CharacterSlotService characterSlotService;

    @Autowired
    public AuthenticationController(TokenService tokenService, PlayerService playerService, UserService userService, UsersService usersService, CharacterSlotService characterSlotService) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.usersService = usersService;
        this.playerService = playerService;
        this.characterSlotService = characterSlotService;
    }

    // Game Login Startup
    @PostMapping("/login_launcher")
    public ResponseEntity<LoginLauncherResponse> loginLauncher(@RequestBody LoginLauncherRequest request) {
        LoginLauncherResponse response = new LoginLauncherResponse();
        //send Post Request to the Authentication Service
        String luuid = this.loginWithCode(request.getOc_authorization_code());
        //IF the UUID is not null or If login is successful
        if (luuid != null) {
            if (!usersService.existsByLnchuuid(luuid)) {
                //IF the login is successful but the user does not exist
                //Create a new User
                Users user = new Users();
                UserEntity userEntity = new UserEntity();
                userEntity.set_id(UUID.randomUUID().toString());
                userEntity.setName("bn-user");

                PlayerEntity playerEntity = new PlayerEntity();
                playerEntity.setUser_id(userEntity.get_id());
                playerEntity.setMax_character_slot(10);
                playerEntity.setAt_network_cafe(0);
                playerEntity.setLast_loggedin_character_id(null);
                playerEntity.setTotal_play_time(0);
                playerEntity.setLogin_count(1);
                playerEntity.setAccesses("{\\\"0.0.0.0\\\":1730871051}");
                playerEntity.setLast_login(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
                playerEntity.setLast_select_character_at(null);
                playerEntity.setCreated_ip("0.0.0.0");
                playerEntity.setLast_login_ip("0.0.0.0");
                playerEntity.setFrom_title_at(null);
                playerEntity.setLast_logout_at(null);
                playerEntity.setLogged_in(0);
                playerEntity.setFirst_purchase(0);
                playerEntity.setFirst_purchase_for_payment(0);
                playerEntity.setBan_type(0);
                playerEntity.setBan_duration_type(0);
                playerEntity.setBan_finished_at(null);
                playerEntity.setBan_basis(0);
                playerEntity.setBirthday(null);
                playerEntity.setBirthday_modify_count(0);
                playerService.createPlayer(playerEntity);
                userEntity.setPlayer(playerEntity);

                CharacterSlotEntity characterSlotEntity = new CharacterSlotEntity();
                characterSlotEntity.setUser_id(userEntity.get_id());
                characterSlotEntity.setCharacter_slot_initial(2);
                characterSlotEntity.setCharacter_slot_buy_max(8);
                characterSlotEntity.setAdditional_character_slot(0);
                characterSlotService.createCharacterSlot(characterSlotEntity);
                userEntity.setCharacterSlot(characterSlotEntity);

                userService.createUser(userEntity);

                user.setLnchuuid(luuid);
                user.setUser(userEntity);
                usersService.createUser(user);
            }

            Users user = usersService.getUserByLnchuuid(luuid);
            String uuid = user.getUser().get_id();

            String token = tokenService.generateToken(uuid);
            response.setUser_id(user.getUser().get_id());
            response.setApi_token(token);
            response.setSp_status(0);
            response.setBan_type(user.getUser().getPlayer().getBan_type());
            response.setBan_finished_at(user.getUser().getPlayer().getBan_finished_at());
            response.setBan_duration_type(user.getUser().getPlayer().getBan_duration_type());
            response.setBan_basis(user.getUser().getPlayer().getBan_basis());
            response.setImage_token("YsSad8AlapKkeje3rsLTHHXE41AJcMzW");
            response.setIs_network_cafe(false); //Should be bound to ip?
            response.setNetwork_cafe_polling_time(60);
            response.setNetwork_cafe_notification_time(1200);
            response.setNetwork_cafe_total_time_played_today(0);
            response.setSb_ret_code(0);
        }


        return ResponseEntity.ok(response);
    }


    private String loginWithCode(String code) {
        JsonObject body = new JsonObject();
        body.addProperty("code", code);
        String response = null;
        try {
            response = RequestManager.sendPostRequest("http://localhost:8081/api/v1/code/validate", code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    // Get Player and Character information

    //TODO: actually createa a settings table, for now hardcode the values
    @PostMapping("users/get_option")
    public ResponseEntity<OptionResponse> getOptions() {
        OptionResponse response = new OptionResponse();
        response.setSb_ret_code(0);
        return ResponseEntity.ok(response);
    }

    //Send personal new (Player Data);
    @PostMapping("users/personal_new")
    public ResponseEntity<PersonalNewResponse> personalNew(@RequestHeader(value = "Authorization") String authorizationHeader) {
        PersonalNewResponse response = new PersonalNewResponse();
        String token = authorizationHeader.substring(7);

        String uuid = tokenService.getUUIDfromToken(token);

        LastContentInfoResponse lastContentInfoResponse = new LastContentInfoResponse();
        lastContentInfoResponse.setCharacter_id("");
        LastContentInfoResponse.Party party = new LastContentInfoResponse.Party();
        party.setParty_id("");
        party.setParty_type(0);
        party.setExpire_time(0);
        lastContentInfoResponse.setParty(party);


        response.set_id(uuid);
        response.setName("bn-user");
        response.setCharacters(new ArrayList<>());
        response.setPlayer(playerService.getPlayerByUserId(uuid));
        response.setLast_content_info(lastContentInfoResponse);
        response.setCharacter_slot(characterSlotService.getCharacterSlotByUserId(uuid));

        return ResponseEntity.ok(response);
    }


}
