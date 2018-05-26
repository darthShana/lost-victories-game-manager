package com.lostVictories.gameManager.rest;


import com.lostVictories.gameManager.service.GameService;
import com.lostVictories.rest.api.GamesService;
import com.lostVictories.rest.api.model.GameUpdateRequest;
import com.lostVictories.rest.api.model.GamesResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Singleton
public class GameResource implements GamesService {

    @Inject
    GameService gameService;

    @Override
    public GamesResponse allGames() {
        return new GamesResponse();
    }

    @Override
    public Response createGame() {
        gameService.createNewGame();
        return Response.ok().build();
    }

    @Override
    public Response updateStatus(GameUpdateRequest body) {
        return null;
    }
}
