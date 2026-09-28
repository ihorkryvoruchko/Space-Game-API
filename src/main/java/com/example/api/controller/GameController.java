package com.example.api.controller;

import com.example.api.model.Game;
import com.example.api.repository.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game updatedGame) {
        return gameRepository.findById(id)
                .map(existingGame -> {
                    existingGame.setScore(updatedGame.getScore());

                    Game savedGame = gameRepository.save(existingGame);
                    return ResponseEntity.ok(savedGame);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}