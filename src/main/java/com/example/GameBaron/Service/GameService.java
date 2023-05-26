package com.example.GameBaron.Service;

import com.example.GameBaron.Entity.Game;
import com.example.GameBaron.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames(){
        List<Game> games = new LinkedList<>();
        gameRepository.findAll().iterator().forEachRemaining(games::add);
        return games;
    }
}
