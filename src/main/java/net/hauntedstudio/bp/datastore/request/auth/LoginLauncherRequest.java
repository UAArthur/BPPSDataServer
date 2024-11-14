package net.hauntedstudio.bp.datastore.request.auth;

import lombok.Getter;

@Getter
public class LoginLauncherRequest {
    private String version;
    private String oc_authorization_code;
}
