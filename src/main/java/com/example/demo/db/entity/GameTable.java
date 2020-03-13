package com.example.demo.db.entity;

import com.example.demo.game.GameState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Game_Table")






public class GameTable implements Serializable {


    @Id

    @Column(name = "game_id")
    private UUID gameId;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private GameState state;

    @Column(name = "count_of_days")

    private int countOfDays;

    @OneToOne(optional = false, cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "mapId")
    private MyMapTable mapId;

    public void setUser(List<UserTable> user) {
        this.user = user;
    }

    public void setMapId(MyMapTable mapId) {
        this.mapId = mapId;
    }

    @OneToMany(mappedBy = "game", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)

    private List<UserTable> user;



    public GameTable(UUID gameId,GameState state,int countOfDays) {
this.gameId= gameId;
this.countOfDays=countOfDays;
        this.state = state;
    }

    public GameTable() {

    }
}
