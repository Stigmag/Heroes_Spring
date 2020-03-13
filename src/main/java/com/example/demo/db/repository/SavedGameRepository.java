package com.example.demo.db.repository;


import com.example.demo.db.entity.SavedGameTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SavedGameRepository  extends JpaRepository<SavedGameTable, UUID> {
}
