package com.example.GameBaron.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.core.annotation.Order;

import java.util.Set;

@Entity
@Table(name = "Platforms")
@Order(3)
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlatformId;

    @NotBlank(message = "The platform name field is mandatory!")
    private String PlatformName;

    @JsonBackReference(value = "game-game_platform")
    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "platforms")
    private Set<Game> games;

    public Platform() {
    }

    public Platform(String platformName, Set<Game> games) {
        PlatformName = platformName;
        this.games = games;
    }

    public Platform(Long platformId, String platformName, Set<Game> games) {
        PlatformId = platformId;
        PlatformName = platformName;
        this.games = games;
    }

    public Long getPlatformId() {
        return PlatformId;
    }

    public String getPlatformName() {
        return PlatformName;
    }

    public void setPlatformName(String platformName) {
        PlatformName = platformName;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
