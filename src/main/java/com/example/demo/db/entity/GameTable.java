package com.example.demo.db.entity;

import com.example.demo.GameState;
import com.example.demo.map.MyMap;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Game_Table")

@ToString(exclude = {"game"})

@PersistenceContext(type=PersistenceContextType.EXTENDED)
public class GameTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private UUID gameId;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private GameState state;

    @Column(name = "count_of_days")

    private int countOfDays;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private MyMapTable mapId;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "saved_Game_Id")
    private SavedGameTable savedGameId;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserTable> user;



    public GameTable(UUID gameId,GameState state,int countOfDays) {
this.gameId= gameId;
this.countOfDays=countOfDays;
        this.state = state;
    }

    public GameTable() {
    }
}
