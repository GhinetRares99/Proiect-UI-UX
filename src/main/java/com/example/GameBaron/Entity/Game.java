package com.example.GameBaron.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.core.annotation.Order;

import java.util.Set;

@Entity
@Table(name = "Games")
@Order(2)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GameId;

    @NotBlank(message = "The name field is mandatory!")
    private String GameName;

    @NotBlank(message = "The genre field is mandatory!")
    private String GameGenre;

    @NotBlank(message = "The creator field is mandatory!")
    private String GameCreator;

    @NotBlank(message = "The publisher field is mandatory!")
    private String GamePublisher;

    @NotBlank(message = "The description field is mandatory!")
    private String GameDescription;

    @Column(columnDefinition = "integer default 0")
    @Min(0)
    private Integer GamePrice;

    @JsonManagedReference(value = "game-game_platform")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "GamePlatform", joinColumns = @JoinColumn(name = "GameId"), inverseJoinColumns = @JoinColumn(name = "PlatformId"))
    private Set<Platform> platforms;

    public Game() {
    }

    public Game(String gameName, String gameGenre, String gameCreator, String gamePublisher, String gameDescription, Integer gamePrice, Set<Platform> platforms) {
        GameName = gameName;
        GameGenre = gameGenre;
        GameCreator = gameCreator;
        GamePublisher = gamePublisher;
        GameDescription = gameDescription;
        GamePrice = gamePrice;
        this.platforms = platforms;
    }

    public Game(Long gameId, String gameName, String gameGenre, String gameCreator, String gamePublisher, String gameDescription, Integer gamePrice, Set<Platform> platforms) {
        GameId = gameId;
        GameName = gameName;
        GameGenre = gameGenre;
        GameCreator = gameCreator;
        GamePublisher = gamePublisher;
        GameDescription = gameDescription;
        GamePrice = gamePrice;
        this.platforms = platforms;
    }

    public Long getGameId() {
        return GameId;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getGameGenre() {
        return GameGenre;
    }

    public void setGameGenre(String gameGenre) {
        GameGenre = gameGenre;
    }

    public String getGameCreator() {
        return GameCreator;
    }

    public void setGameCreator(String gameCreator) {
        GameCreator = gameCreator;
    }

    public String getGamePublisher() {
        return GamePublisher;
    }

    public void setGamePublisher(String gamePublisher) {
        GamePublisher = gamePublisher;
    }

    public String getGameDescription() {
        return GameDescription;
    }

    public void setGameDescription(String gameDescription) {
        GameDescription = gameDescription;
    }

    public Integer getGamePrice() {
        return GamePrice;
    }

    public void setGamePrice(Integer gamePrice) {
        GamePrice = gamePrice;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<Platform> platforms) {
        this.platforms = platforms;
    }
}
