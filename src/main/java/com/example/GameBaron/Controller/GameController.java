package com.example.GameBaron.Controller;

import com.example.GameBaron.Entity.Game;
import com.example.GameBaron.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    @RequestMapping(path = "GameBaron/Games/getGames")
    public List<Game> getGames(){
        List<Game> games = gameService.getGames();
        return games;
    }
}
