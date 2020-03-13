package com.example.demo.db.repository;

import com.example.demo.db.entity.GameMapTable;
import com.example.demo.db.entity.MyMapTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameMapRepository  extends JpaRepository<GameMapTable, Integer> {


}

