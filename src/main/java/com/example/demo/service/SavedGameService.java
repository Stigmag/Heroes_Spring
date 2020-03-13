package com.example.demo.service;



import com.example.demo.game.Game;
import com.example.demo.db.entity.SavedGameTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SavedGameService {

    SavedGameTable save(Game game);


   Optional<SavedGameTable> getById(UUID id);

    void delete(UUID id);

    List<SavedGameTable> getAll();




}
