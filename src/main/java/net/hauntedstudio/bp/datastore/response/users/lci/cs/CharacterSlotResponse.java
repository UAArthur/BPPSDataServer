package net.hauntedstudio.bp.datastore.response.users.lci.cs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterSlotResponse {
    private int character_slot_initial;
    private int character_slot_max;
    private int additional_character_slot;
}
