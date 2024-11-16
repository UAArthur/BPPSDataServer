package net.hauntedstudio.bp.datastore.controllers.buffer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buff/")
public class MapBufferController {

    @PostMapping("get_buff_for_map")
    public ResponseEntity<String> getBuffForMap() {
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
