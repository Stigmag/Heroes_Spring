package com.example.demo.service;


import com.d43.tbs.control.MapChoosing;
import com.d43.tbs.control.MapPlaying;
import com.example.demo.db.entity.GameMapTable;
import com.example.demo.db.entity.MyMapTable;
import com.example.demo.map.MyMap;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameMapService {

    GameMapTable save(GameMapTable myMap);


    Optional<GameMapTable> getById(int id);

    void delete(int id);

    List<GameMapTable> getAll();




}
