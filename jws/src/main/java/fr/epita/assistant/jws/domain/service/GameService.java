package fr.epita.assistant.jws.domain.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.base.Objects;

import fr.epita.assistant.jws.converter.Converter;
import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.data.repository.GameRepository;
import fr.epita.assistant.jws.data.repository.PlayerRepository;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.presentation.rest.GameResource;
import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import lombok.val;

@ApplicationScoped
@AllArgsConstructor @NoArgsConstructor @With
public class GameService {
    @Inject GameRepository gameRepository;
    @Inject PlayerRepository playerRepository;
    @Inject Converter converter;

    public List<GameEntity> getGames() {
        return gameRepository.findAll().list().stream()
        .map(model -> converter.convertGameModelToEntity(model))
        .collect(Collectors.toList());
    } 

    public String createMap(String path)
    {
        Path file = Paths.get(path);
        StringBuilder map = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(file);
            for (String line : lines)
            {
                map.append(line);
                map.append('\n');
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map.toString();
    }
    
    public List<String> mapStringToList(String map)
    {
        int i = 0;
        List<String> mapList = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        while (i < map.length())
        {
            if (map.charAt(i) == '\n')
            {
                mapList.add(line.toString());
                line = new StringBuilder();
            }
            else
            {
                line.append(map.charAt(i));
            }
            i++;
        }
        return mapList;
    }

    public boolean idExist(Long id)
    {
        return gameRepository.findAll().list().stream()
            .anyMatch(game -> game.id.equals(id));
    }

    public PlayerModel playerSetPosition(PlayerModel player, int playerNumber)
    {
        switch (playerNumber)
        {
            case 2:
                player.posx = 15;
                player.posy = 1;
                break;
            case 3:
                player.posx = 15;
                player.posy = 13;
                break;
            default:
                player.posx = 1;
                player.posy = 13;
                break;
        }
        return player;
    }

    @Transactional
    public GameEntity startGame(Long id)
    {
        GameModel gameModel = gameRepository.findAll().list().stream()
            .filter(game -> Objects.equal(game.id, id))
            .findFirst()
            .orElse(null);
        gameModel.startTime = LocalDateTime.now();

        if (gameModel.players.size() <= 1)
        {
            gameModel.state = GameState.FINISHED;
        }
        else
        {
            gameModel.state = GameState.RUNNING;
        }
        return converter.convertGameModelToEntity(gameModel);
    }

    @Transactional
    public GameEntity joinGame(Long id, String playerName)
    {
        GameModel gameModel = gameRepository.findAll().list().stream()
            .filter(game -> Objects.equal(game.id, id))
            .findFirst()
            .orElse(null);

        if (gameModel == null || gameModel.state.equals(GameState.RUNNING) || gameModel.state.equals(GameState.FINISHED) || gameModel.players.size() >= 4)
            return null;

        PlayerModel playerModel = new PlayerModel()
            .withName(playerName)
            .withLives(3);
        playerModel = playerSetPosition(playerModel, gameModel.players.size() + 1);
        playerRepository.persist(playerModel);
        gameModel.players.add(playerModel); 

        return converter.convertGameModelToEntity(gameModel);
    }

    @Transactional
    public GameEntity createGame(String playerName)
    {
        String givenMap = System.getenv("JWS_MAP_PATH");
        if (givenMap == null)
            givenMap = "src/test/resources/map1.rle";
        
        // Create First new player
        List<PlayerModel> players = new ArrayList<>();
        PlayerModel playerModel = new PlayerModel()
            .withName(playerName)
            .withPosx(1)
            .withPosy(1)
            .withLives(3);
        playerRepository.persist(playerModel);
        players.add(playerModel);

        // Create game
        GameModel gameModel = new GameModel()
            .withStartTime(LocalDateTime.now())
            .withState(GameState.STARTING)
            .withPlayers(players)
            .withMap(createMap(givenMap));
        gameRepository.persist(gameModel);
        return converter.convertGameModelToEntity(gameModel);
    }
}

