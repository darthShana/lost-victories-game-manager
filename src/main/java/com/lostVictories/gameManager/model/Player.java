package com.lostVictories.gameManager.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "players")
public class Player extends BaseModel{

    @Id
    UUID id;
    @ManyToOne
    @JoinColumn(name = "fk_game")
    Game game;
    @ManyToOne
    @JoinColumn(name = "fk_user")
    User user;
    String country;

    public Player(UUID id, User user, Game game, String country) {
        this.id = id;
        this.user = user;
        this.game = game;
        this.country = country;
    }
}
