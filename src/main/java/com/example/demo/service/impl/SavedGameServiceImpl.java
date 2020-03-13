package com.example.demo.service.impl;


import com.example.demo.game.Game;
import com.example.demo.db.entity.SavedGameTable;
import com.example.demo.db.repository.SavedGameRepository;
import com.example.demo.service.SavedGameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SavedGameServiceImpl implements SavedGameService {

    private final SavedGameRepository savedGameRepository;

    public SavedGameServiceImpl(SavedGameRepository savedGameRepository) {
        this.savedGameRepository = savedGameRepository;
    }


    @Override
    public SavedGameTable save(Game game) {

        return savedGameRepository.saveAndFlush( new SavedGameTable(game.getGameId()));
    }

    @Override
    public void delete(UUID id) {
        savedGameRepository.deleteById(id);

    }
@Override
    public Optional<SavedGameTable> getById(UUID id) {
        return savedGameRepository.findById(id);
    }

    @Override
    public List<SavedGameTable> getAll() {
        return savedGameRepository.findAll();
    }
}