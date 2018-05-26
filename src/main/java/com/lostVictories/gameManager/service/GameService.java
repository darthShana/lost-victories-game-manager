package com.lostVictories.gameManager.service;

import com.lostVictories.gameManager.dao.GameDAO;
import com.lostVictories.gameManager.dao.UserDAO;
import com.lostVictories.gameManager.model.Game;

import javax.inject.Inject;
import java.util.Date;
import java.util.UUID;

public class GameService {

    @Inject
    GameDAO gameDAO;
    @Inject
    UserDAO userDAO;

    public void createNewGame() {
        gameDAO.save(new Game(UUID.randomUUID(), "same name", new Date()));
    }

    public void joinGame(UUID gameID, UUID userID, String country) {
        Game byID = gameDAO.getByID(gameID);
        byID.addPlayer(userDAO.getByID(userID), country);
        gameDAO.save(byID);

    }
}
