package com.example.demo.db.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="User_Table")
@Data

public class UserTable implements Serializable {
    @Id
    @Column(name = "UserId")
    private UUID userId;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private GameTable game;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SavedGameTable> savedGames;

    @Column(name = "army_state")
    private String armyState;

    public UserTable(UUID userId, String armyState) {
        this.armyState= armyState;
        this.userId=userId;
    }

    public GameTable getGame() {
        return game;
    }

    public void setGame(GameTable game) {
        this.game = game;
    }
}



