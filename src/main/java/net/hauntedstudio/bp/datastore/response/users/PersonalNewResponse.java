package net.hauntedstudio.bp.datastore.response.users;

import lombok.Getter;
import lombok.Setter;
import net.hauntedstudio.bp.datastore.entity.CharacterSlotEntity;
import net.hauntedstudio.bp.datastore.entity.PlayerEntity;
import net.hauntedstudio.bp.datastore.response.users.lci.LastContentInfoResponse;

import java.util.List;

@Getter
@Setter
public class PersonalNewResponse {
    private String _id;
    private String name;
    private List<String> characters;
    private PlayerEntity player;
    private LastContentInfoResponse last_content_info;
    private CharacterSlotEntity character_slot;
}
