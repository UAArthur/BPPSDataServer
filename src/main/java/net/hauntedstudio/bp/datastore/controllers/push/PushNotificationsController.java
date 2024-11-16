package net.hauntedstudio.bp.datastore.controllers.push;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiext/push_notifications")
public class PushNotificationsController {

    //Implement PushNotificaitonService
    @GetMapping("/get_delivered_message")
    public String getDeliveredMessage() {
        return "[]";
    }
}
