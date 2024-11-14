package net.hauntedstudio.bp.datastore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    private String user_id;

    @Column(name = "max_character_slot")
    private int max_character_slot;

    @Column(name = "at_network_cafe")
    private int at_network_cafe;

    @Column(name = "last_loggedin_character_id")
    private String last_loggedin_character_id;

    @Column(name = "total_play_time")
    private int total_play_time;

    @Column(name = "login_count")
    private int login_count;

    @Column(name = "accesses")
    private String accesses;

    @Column(name = "last_login")
    private Date last_login;

    @Column(name = "last_select_character_at")
    private Date last_select_character_at;

    @Column(name = "created_ip")
    private String created_ip;

    @Column(name = "last_login_ip")
    private String last_login_ip;

    @Column(name = "from_title_at")
    private Date from_title_at;

    @Column(name = "last_logout_at")
    private Date last_logout_at;

    @Column(name = "logged_in")
    private int logged_in;

    @Column(name = "first_purchase")
    private int first_purchase;

    @Column(name = "first_purchase_for_payment")
    private int first_purchase_for_payment;

    @Column(name = "ban_type")
    private int ban_type;

    @Column(name = "ban_duration_type")
    private int ban_duration_type;

    @Column(name = "ban_finished_at")
    private Date ban_finished_at;

    @Column(name = "ban_basis")
    private int ban_basis;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "birthday_modify_count")
    private int birthday_modify_count;
}
