package com.example.demo.service.impl;


import com.example.demo.JsonParser;
import com.example.demo.db.entity.GameMapTable;
import com.example.demo.db.entity.MyMapTable;
import com.example.demo.db.repository.GameMapRepository;
import com.example.demo.db.repository.MapRepository;
import com.example.demo.map.MyMap;
import com.example.demo.service.GameMapService;
import com.example.demo.service.MapService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class GameMapServiceImpl implements GameMapService {

    private final GameMapRepository gameMapRepository;

    public GameMapServiceImpl(GameMapRepository gameMapRepository) {
        this.gameMapRepository =gameMapRepository;
    }



    @Override
    public void delete(int id) {
        gameMapRepository.deleteById(id);

    }

    @Override
    public GameMapTable save(GameMapTable myMap) {
        return gameMapRepository.saveAndFlush( myMap);
    }

    @Override
    public Optional<GameMapTable> getById(int id) {
        return gameMapRepository.findById(id);
    }

    @Override
    public List<GameMapTable> getAll() {
        return gameMapRepository.findAll();
    }
}