package net.hauntedstudio.bp.datastore.response.users.lci;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LastContentInfoResponse {
    private String character_id;
    private Party party;

    @Getter
    @Setter
    public static class Party{
        private String party_id;
        private int party_type;
        private int expire_time;
    }
}
