package com.lostVictories.gameManager.dao;

import com.lostVictories.gameManager.model.Game;
import com.lostVictories.gameManager.model.query.QGame;

import java.util.UUID;

public class GameDAO {
    public void save(Game game) {
        game.save();
    }

    public Game getByID(UUID gameID) {
        return new QGame().id.eq(gameID).findOne();
    }
}
