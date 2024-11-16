package net.hauntedstudio.bp.datastore.response.users;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OptionResponse {
    private List<String> data = new ArrayList<>();
    private int sb_ret_code;
}
