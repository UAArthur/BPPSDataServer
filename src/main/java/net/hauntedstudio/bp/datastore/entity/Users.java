package net.hauntedstudio.bp.datastore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String lnchuuid; //UUID from the Authentication Service

    @OneToOne
    @JoinColumn(name = "user__id")
    private UserEntity user;
}
