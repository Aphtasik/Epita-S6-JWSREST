package fr.epita.assistant.jws.presentation.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.domain.service.GameService;
import fr.epita.assistant.jws.presentation.rest.request.CreateGameRequestDTO;
import fr.epita.assistant.jws.presentation.rest.response.GameResponseDTO;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    @Inject GameService gameService;


    @GET @Path("/")
    public List<GameResponseDTO> gameList() {
        var games = gameService.getAllGames();
        return games.stream()
                .map(game -> new GameResponseDTO(
                    game.id,
                    game.startTime,
                    game.state
                ))
                .collect(Collectors.toList());
    }

    @POST @Path("/")
    public Response create(CreateGameRequestDTO request) {

        if (request == null || request.name == null) {
            return Response.status(400).build();
        }
        gameService.createGame(request.name);
        return null;
    }
}