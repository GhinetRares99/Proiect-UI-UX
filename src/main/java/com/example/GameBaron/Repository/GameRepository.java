package com.example.GameBaron.Repository;

import com.example.GameBaron.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
