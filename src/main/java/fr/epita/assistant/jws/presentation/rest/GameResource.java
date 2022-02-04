package fr.epita.assistant.jws.presentation.rest;

import java.util.List;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.service.GameService;


@ApplicationScoped
@Path("/games")
public class GameResource {
    @Inject GameService gameService;
    

    @PUT
    public Response createGame(String playerName)
    {
        if (playerName == null) {
            return Response.status(400).build();
        }
        return Response.ok(gameService.createGame(playerName)).build();
    }

    @GET
    public List<GameEntity> getGames() 
    {
        return gameService.getGames();
    }
}
