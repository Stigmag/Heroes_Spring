package com.example.demo.db.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "MyMap_Table")


public class MyMapTable implements Serializable {


    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="game_id")
    private GameTable figureId;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_Game")
    private GameTable gameId;

    @Column(name = "state_Map")
    private String stateMap;



    public MyMapTable(String stateMap, UUID mapID) {
        this.stateMap = stateMap;
        this.id = mapID;
    }

    public UUID getId() {
        return id;
    }



    public GameTable getGameId() {
        return gameId;
    }


    public void setGameId(GameTable gameId) {
        this.gameId = gameId;
    }
}

