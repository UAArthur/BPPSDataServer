package net.hauntedstudio.bp.datastore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "user")
public class UserEntity {
    @Id
    public String _id;
    private String name;

    @OneToOne
    @JoinColumn(name = "player_user_id")
    private PlayerEntity player;

}
