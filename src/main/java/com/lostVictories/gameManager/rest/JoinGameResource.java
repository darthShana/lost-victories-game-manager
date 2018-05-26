package com.lostVictories.gameManager.rest;

import com.lostVictories.gameManager.service.GameService;
import com.lostVictories.rest.api.RegisterService;
import com.lostVictories.rest.api.model.JoinGameRequest;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Singleton
public class JoinGameResource implements RegisterService{

    @Inject
    GameService gamesService;

    @Override
    public Response joinGame(JoinGameRequest body) {
        gamesService.joinGame(UUID.fromString(body.getGameID()), UUID.fromString(body.getUserID()), body.getCountry());
        return Response.ok().build();
    }
}
