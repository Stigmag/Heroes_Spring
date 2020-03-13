package com.example.demo.db.entity;

import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Saved_Game_Table")





public class SavedGameTable {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saved_Game_Id")
    private UUID savedGameId;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserTable user;



    public SavedGameTable(UUID id) {
        this.savedGameId=id;

    }
}
