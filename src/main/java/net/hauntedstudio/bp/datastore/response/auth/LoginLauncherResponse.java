package net.hauntedstudio.bp.datastore.response.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoginLauncherResponse {
    private String user_id;
    private String api_token;
    private Integer sp_status;
    private Integer ban_type;
    private Date ban_finished_at;
    private Integer ban_duration_type;
    private Integer ban_basis;
    private String image_token;
    private Boolean is_network_cafe;
    private Integer network_cafe_polling_time;
    private Integer network_cafe_notification_time;
    private Integer network_cafe_total_time_played_today;
    private Integer sb_ret_code;


}
