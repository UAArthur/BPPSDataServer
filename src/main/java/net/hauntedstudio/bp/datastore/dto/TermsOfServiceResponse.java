package net.hauntedstudio.bp.datastore.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TermsOfServiceResponse {
    private List<TermOfUse> terms_of_use;
    private int sb_ret_code;
}
