package com.lostVictories.gameManager;

import com.lostVictories.gameManager.model.Game;
import com.lostVictories.gameManager.model.User;

import javax.persistence.*;

@Embeddable
public class Player {

    @ManyToOne
    @JoinColumn(name = "fk_game")
    Game game;
    @ManyToOne
    @JoinColumn(name = "fk_user")
    User user;
    String country;

    public Player(User user, Game game, String country) {
        this.user = user;
        this.game = game;
        this.country = country;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Player)){
            return false;
        }
        Player other = (Player) obj;
        if(!other.game.getId().equals(game.getId())){
            return false;
        }
        if(!other.user.getId().equals(user.getId())){
            return false;
        }
        if(!country.equals(other.country)){
            return false;
        }


        return true;
    }
}
