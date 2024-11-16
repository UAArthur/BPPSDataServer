package net.hauntedstudio.bp.datastore.controllers.tutorial;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apiext/tutorial")
public class TutorialController {


    @PostMapping("step_log")
    public stepLog getStepLog() {
        stepLog response = new stepLog();
        response.setSb_ret_code(0);
        return response;
    }

    @Getter
    @Setter
    public static class stepLog{
        private List<String> step_log = new ArrayList<>();
        private int sb_ret_code;
    }
}
