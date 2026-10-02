package com.example.api.controller;

import com.example.api.model.Game;
import com.example.api.model.User;
import com.example.api.repository.GameRepository;
import com.example.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public GameController(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> createGame(@RequestBody(required = false) Game game, Authentication authentication) {
        User user = userRepository.findByName(authentication.getName())
                .orElse(null);
        if (user == null) {
            return ResponseEntity.status(401).build();
        }

        if (game == null) {
            game = new Game();
        }

        game.setUserId(user.getId());
        if (game.getScore() == null) {
            game.setScore(0);
        }

        return ResponseEntity.ok(gameRepository.save(game));
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