package com.lostVictories.gameManager.rest;


import com.lostVictories.rest.api.GamesService;
import com.lostVictories.rest.api.model.GamesResponse;

import javax.inject.Singleton;
import javax.ws.rs.Path;


@Singleton
@Path("/games")
public class GameResource implements GamesService {


    @Override
    public GamesResponse allGames() {
        return new GamesResponse();
    }
}
