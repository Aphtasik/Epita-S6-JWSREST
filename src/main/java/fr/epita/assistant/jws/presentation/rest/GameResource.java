package fr.epita.assistant.jws.presentation.rest;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.epita.assistant.jws.utils.GameState;
import lombok.Value;
import lombok.With;

@ApplicationScoped
@Path("/games")
public class GameResource {

    private final Set<Game> gameSet = new HashSet<>();

    @PUT
    public Set<Game> createGame(final Game game)
    {
        gameSet.add(game);
        return gameSet;
    }

    @GET
    @Path("/{gameId}")
    public Game getGame(@PathParam("gameId") final Long id)
    {
        return gameSet.stream()
        .filter(game -> Objects.equals(game.id, id))
        .findFirst()
        .orElse(null);
    }

    @GET
    public Set<Game> findAll() 
    {
        return gameSet;
    }
    @Value @With 
    public static class Game
    {
        public Long id;
        public Timestamp startTime;
        public GameState state;
        public String map;
        public @OneToMany(cascade = CascadeType.ALL) List<Player> players;
    }

    @Value @With
    public static class Player
    {
        public Long id;
        public Timestamp lastBomb;
        public Timestamp lastMovement; 
        public int lives;
        public String name;
        public int posx;
        public int posy;
        public @ManyToOne Game game;
    }
    
}
