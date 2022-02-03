package fr.epita.assistant.jws.presentation.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.epita.assistant.jws.presentation.rest.response.GameResponseDTO;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    @GET @Path("/")
    public List<GameResponseDTO> helloWorld() {
        return null;
    }
}