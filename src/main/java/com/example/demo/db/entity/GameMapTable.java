package com.example.demo.db.entity;


import com.d43.tbs.control.MapPlaying;
import com.example.demo.JsonParser;
import com.example.demo.game.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Game_Map_Table")


public class GameMapTable implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapId")
    private int mapId;



    @ManyToMany(fetch = FetchType.LAZY)

    @JoinTable(
            name = "users",
            joinColumns = @JoinColumn(name = "mapId"),
            inverseJoinColumns = @JoinColumn(name = "UserId"))

    private Set<UserTable> users;;

    @Column(name = "state_Map")

    private String stateMap;



    public GameMapTable(String stateMap) {
        this.stateMap = stateMap;

    }

    public int getId() {
        return mapId;
    }


    public Set<UserTable> getUsers() {
        return users;
    }

    public void setUsers(UserTable user) {
        this.users.add(user);
    }

    public GameMapTable(MapPlaying map) {
        this.stateMap= JsonParser.parseToJson(map);
    }

    public GameMapTable() {
    }
}