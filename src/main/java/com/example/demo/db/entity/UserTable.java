package com.example.demo.db.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="User_Table")
@Data

public class UserTable implements Serializable {
    @Id
    @Column(name = "UserId")
    private UUID userId;



    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GameTable game;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SavedGameTable> savedGames;


    @ManyToMany(mappedBy = "users")
    Set<GameMapTable> likes;


    public UserTable(UUID userId) {

        this.userId=userId;
    }

    public GameTable getGame() {
        return game;
    }

    public void setGame(GameTable game) {
        this.game = game;
    }

    public UserTable() {
    }
}



