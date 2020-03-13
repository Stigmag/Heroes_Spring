package com.example.demo.db.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "MyMap_Table")


public class MyMapTable implements Serializable {


    @Id
    @Column(name = "mapId")
    private UUID mapId;



    @OneToOne (mappedBy = "mapId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private GameTable gameId;

    @Column(name = "state_Map")
    private String stateMap;



    public MyMapTable(String stateMap, UUID mapID) {
        this.stateMap = stateMap;
        this.mapId = mapID;
    }

    public UUID getId() {
        return mapId;
    }



    public GameTable getGameId() {
        return gameId;
    }


    public void setGameId(GameTable gameId) {
        this.gameId = gameId;
    }

    public MyMapTable() {
    }
}

