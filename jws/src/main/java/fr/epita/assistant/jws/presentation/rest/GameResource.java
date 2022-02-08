package fr.epita.assistant.jws.presentation.rest;

import java.util.ArrayList;
import java.util.List;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.epita.assistant.jws.converter.Converter;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.service.GameService;
import fr.epita.assistant.jws.presentation.rest.request.CreateGameRequestDTO;
import fr.epita.assistant.jws.presentation.rest.response.CreateGameResponseDTO;
import fr.epita.assistant.jws.presentation.rest.response.GameListResponseDTO;


@ApplicationScoped
@Path("/games")
public class GameResource {
    @Inject GameService gameService;
    @Inject Converter convert;
    

    @POST
    public Response createGame(CreateGameRequestDTO playerName)
    {
        if (playerName == null || playerName.name == null) {
            return Response.status(400).build();
        }
        GameEntity gameEntity = gameService.createGame(playerName.name);
        CreateGameResponseDTO gameResponseDTO = convert.convertGameEntityToCreateResponse(gameEntity);
        return Response.ok(gameResponseDTO).build();
    }

    @GET
    public Response listGames() 
    {
        List<GameEntity> games = gameService.getGames();
        List<GameListResponseDTO> gameListResponseDTO = new ArrayList<>();
        for (GameEntity game : games) {
            gameListResponseDTO.add(convert.convertGameEntityToGameListReponse(game));
        }

        return Response.ok(gameListResponseDTO).build();
    }

    @GET
    @Path("/{gameId}")
    public Response gameInfo(@PathParam("gameId") Long gameId)
    {
        List<GameEntity> games = gameService.getGames();
        CreateGameResponseDTO searchedGame = null;
        for (GameEntity game : games) {
            if (game.id.equals(gameId)) {
                searchedGame = convert.convertGameEntityToCreateResponse(game);
                break;
            }
        }
        
        if (searchedGame == null)
            return Response.status(404).build();
        return Response.ok(searchedGame).build();
    }


    @POST
    @Path("/{gameId}")
    public Response joinGame(@PathParam("gameId") Long id, CreateGameRequestDTO playerName)
    {   
        if (playerName == null || playerName.name == null) {
            return Response.status(400).build();
        } 
        else if (!gameService.idExist(id)) {
            return Response.status(404).build();
        }

        GameEntity game = gameService.joinGame(id, playerName.name);
        if (game == null)
            return Response.status(400).build();
        
        return Response.ok(convert.convertGameEntityToCreateResponse(game)).build();
    }

    @PATCH
    @Path("/{gameId}/start")
    public Response startGame(@PathParam("gameId") Long id)
    {
        if (!gameService.idExist(id)) {
            return Response.status(404).build();
        }
        GameEntity game = gameService.startGame(id);
        return Response.ok(convert.convertGameEntityToCreateResponse(game)).build();
    }
}
