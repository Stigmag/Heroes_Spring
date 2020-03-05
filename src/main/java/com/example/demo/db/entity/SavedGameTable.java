package com.example.demo.db.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="Game_Table")




@PersistenceContext(type=PersistenceContextType.EXTENDED)
public class SavedGameTable {

    @Id
    @Column(name = "saved_Game_Id")
    private int userId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private UserTable user;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private GameTable gameId;

}
