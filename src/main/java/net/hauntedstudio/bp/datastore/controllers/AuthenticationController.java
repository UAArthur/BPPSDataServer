package net.hauntedstudio.bp.datastore.controllers;

//Controller handles everything related to authentication

import com.google.gson.JsonObject;
import net.hauntedstudio.bp.datastore.entity.PlayerEntity;
import net.hauntedstudio.bp.datastore.entity.UserEntity;
import net.hauntedstudio.bp.datastore.entity.Users;
import net.hauntedstudio.bp.datastore.repository.UsersRepository;
import net.hauntedstudio.bp.datastore.request.auth.LoginLauncherRequest;
import net.hauntedstudio.bp.datastore.response.auth.LoginLauncherResponse;
import net.hauntedstudio.bp.datastore.services.TokenService;
import net.hauntedstudio.bp.datastore.services.auth.PlayerService;
import net.hauntedstudio.bp.datastore.services.auth.UserService;
import net.hauntedstudio.bp.datastore.services.auth.UsersService;
import net.hauntedstudio.bp.datastore.utils.RequestManager;
import net.hauntedstudio.bp.datastore.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/apiext")
public class AuthenticationController {

    private final TokenService tokenService;

    private final UserService userService;

    private final UsersService usersService;

    private final PlayerService playerService;

    @Autowired
    public AuthenticationController(TokenService tokenService, PlayerService playerService, UserService userService, UsersService usersService) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.usersService = usersService;
        this.playerService = playerService;
    }

    // Game Login Startup
    @PostMapping("/login_launcher")
    public ResponseEntity<LoginLauncherResponse> loginLauncher(@RequestBody LoginLauncherRequest request) {
        LoginLauncherResponse response = new LoginLauncherResponse();
        //send Post Request to the Authentication Service
        //TODO: So long AntiCheat is not removed, hardcode the code.
        String luuid = this.loginWithCode(request.getOc_authorization_code());
        String uuid = UUID.randomUUID().toString();
        //IF the UUID is not null or If login is successful
        if (luuid != null) {
            //Check if a User with that UUID exists
            Users user = usersService.getUserByLnchuuid(luuid);
            if (user == null) {
                //If no user exists, create a new user
                PlayerEntity playerEntity = new PlayerEntity();
                playerEntity.setUser_id(uuid);
                playerEntity.setMax_character_slot(10);
                playerEntity.setAt_network_cafe(0);
                playerEntity.setLast_loggedin_character_id(null);
                playerEntity.setTotal_play_time(0);
                playerEntity.setLogin_count(1);
                playerEntity.setAccesses("{\\\"0.0.0.0\\\":1730871051}");
                playerEntity.setLast_login(null);
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
                //Save the new user
                playerService.createPlayer(playerEntity);

                UserEntity userEntity = new UserEntity();
                userEntity.set_id(uuid);
                userEntity.setName("bn-user");
                userEntity.setPlayer(playerEntity);
                userService.createUser(userEntity);

                Users newUser = new Users();
                newUser.setLnchuuid(luuid);
                newUser.setUser(userEntity);
                usersService.createUser(newUser);
            }

            String token = tokenService.generateToken(uuid);
            assert user != null;
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

        if (response != null) {
            return response;
        }
        return null;
    }


}
