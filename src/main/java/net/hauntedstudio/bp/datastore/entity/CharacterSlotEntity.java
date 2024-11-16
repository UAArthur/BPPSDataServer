package net.hauntedstudio.bp.datastore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "character_slot")
public class CharacterSlotEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    private String user_id;
    private int character_slot_initial;
    private int character_slot_buy_max;
    private int additional_character_slot;
}
