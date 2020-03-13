package com.example.demo.controller;

import com.example.demo.db.entity.MyMapTable;
import com.example.demo.db.entity.UserTable;
import com.example.demo.db.repository.MapRepository;
import com.example.demo.game.Game;
import com.example.demo.db.entity.GameTable;
import com.example.demo.db.repository.GameRepository;
import com.example.demo.game.User;
import com.example.demo.map.MyMap;
import com.example.demo.service.GameService;
import com.example.demo.service.MapService;
import com.example.demo.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DBController {
    private final GameService gameService;
    private final MapService mapService;
    private final UserService userService;

    public DBController(GameService gameService,MapService mapService,UserService userService
    ) {
        this.gameService = gameService;
        this.mapService= mapService;
        this.userService= userService;
    }
    MyMapTable mapTable;
    GameTable gameTable;
    UserTable user;

    @PostMapping("/add-map")
    public String addMap(@RequestBody MyMap map) {

      mapTable= mapService.save(map);

        return new DBResponse().text;
    }
    @PostMapping("/add-data")
    public String addData(@RequestBody Game request) {

      gameTable= new GameTable(request.getGameId(),request.getState(),request.getCountOfDays());
      gameTable.setMapId(mapTable);
              gameService.save(gameTable);

        mapTable.setGameId(gameTable);

        return new DBResponse().text;
    }
    @PostMapping("/add-user")
    public String addUser(@RequestBody User request) {

        user=userService.save(request);

        return new DBResponse().text;
    }
    @Data
    public static class DBResponse {
        private String text = "ADD DATA";
    }




}
