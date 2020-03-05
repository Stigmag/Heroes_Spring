package com.example.demo.resource;

import com.example.demo.Game;
import com.example.demo.GameState;
import com.example.demo.db.entity.GameTable;
import com.example.demo.db.repository.GameRepository;
import com.example.demo.db.repository.MapRepository;
import com.example.demo.db.repository.UserRepository;
import com.sun.org.apache.xerces.internal.impl.xs.XSAttributeUseImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/data")
public class DataController {

    private static GameRepository gameRepository = null;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapRepository mapRepository;

    public DataController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping(value = "/all")
    public List<GameTable> getAll(){
        return gameRepository.findAll();
    }

    @PostMapping(value = "/load")
    public GameTable load() {
Game game= new Game();
        GameTable gameTable= new GameTable(game.getId(),game.getState(), game.getCountOfDays());
        return gameRepository.save(gameTable);
    }
    @Data
  private class Game {
        UUID id;
        GameState state;
        int countOfDays;
        Game(){
            this.id= UUID.randomUUID();
            this.countOfDays=3;
            this.state= GameState.ACTIVE;
        }
    }
}
