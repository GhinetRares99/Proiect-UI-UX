package com.example.GameBaron.Configuration;

import com.example.GameBaron.Entity.Game;
import com.example.GameBaron.Entity.Platform;
import com.example.GameBaron.Entity.User;
import com.example.GameBaron.Repository.GameRepository;
import com.example.GameBaron.Repository.PlatformRepository;
import com.example.GameBaron.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class AppConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, GameRepository gameRepository, PlatformRepository platformRepository){

        return args -> {

            User rares = new User("Rares123", "parola123", "rares.ghinet@gmail.com");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(rares.getPassword());
            rares.setPassword(encodedPassword);
            userRepository.save(rares);

            Platform ps5 = new Platform("PS5", null);
            Platform xbox = new Platform("XBOX", null);
            Platform pc = new Platform("PC", null);
            platformRepository.save(ps5);
            platformRepository.save(xbox);
            platformRepository.save(pc);

            Game game1 = new Game("Call of Duty: Future Warfare", "FPS", "Infinity Ward", "Activision", "A military shooter.", 60, null);
            Game game2 = new Game("Grand Theft Auto 6", "Open World", "Rockstar Games", "Take Two", "An open world game.", 50, null);
            game1.setPlatforms(Set.of(ps5, xbox, pc));
            game2.setPlatforms(Set.of(ps5, pc));
            gameRepository.save(game1);
            gameRepository.save(game2);
        };
    }
}
