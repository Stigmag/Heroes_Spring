package com.example.demo.game;


import com.example.demo.map.MyMap;
import com.example.demo.map.Point;

import org.springframework.stereotype.Component;



import java.util.UUID;

import static com.example.demo.game.GameState.*;

@Component

public class Game {


private UUID gameId;
    private final MyMap map;
    private User user;
    private int countOfDays;
private GameState state;
    public Game( ) {
        this.gameId= UUID.randomUUID();
        this.map = new MyMap();
        this.countOfDays = 0;
        this.user= new User();

    }


    public UUID getGameId() {
        return gameId;
    }

    public MyMap getMap() {
        return map;
    }

    public User getUser() {
        return user;
    }

    public int getCountOfDays() {
        return countOfDays;
    }

    public GameState getState() {
        return state;
    }

    public void start() {
       state = ACTIVE;

        while (state == ACTIVE) {

            state = user.doGame(map);
           // DataController.load(new GameTable(gameId,state,countOfDays));
       if (state == WAIT)

            {
                this.countOfDays++;


            }
            if (isPlace(user.getCurrentPoint())) {
                //TODO: visit this place or not

            }

        }
        if (state == FINISH) {
         //TODO: end game;

        }
    }

    private  boolean isPlace(Point currentPoint) {
        return map.getMapMatrix()[currentPoint.getX()][currentPoint.getY()] == (byte) 1111;
    }
}
