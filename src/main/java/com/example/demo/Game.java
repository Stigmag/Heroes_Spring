package com.example.demo;


import com.example.demo.map.MyMap;
import com.example.demo.map.Point;
import org.springframework.stereotype.Component;

import static com.example.demo.GameState.*;

@Component
public class Game {


    private final MyMap map;
    private User user;
    private int countOfDays;

    public Game() {
        this.map = new MyMap();
        this.countOfDays = 0;
        this.user= new User();
    }




    public void start() {
        GameState state = ACTIVE;

        while (state == ACTIVE) {

            state = user.doGame(map);
            if (state == WAIT) {
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
