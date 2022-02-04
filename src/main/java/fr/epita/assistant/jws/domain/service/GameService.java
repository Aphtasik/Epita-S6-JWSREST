package fr.epita.assistant.jws.domain.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.data.repository.GameRepository;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.utils.GameState;
import lombok.With;
import fr.epita.assistant.jws.converter.Converter;

@ApplicationScoped
public class GameService {
    @Inject GameRepository gameRepository;
    @Inject Converter converter;

    public List<GameEntity> getAllGames() {
        return gameRepository.findAll().stream().map(game -> converter.convertGameModelToEntity(game)).collect(Collectors.toList());
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
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return map.toString();
    }

    @Transactional
    public GameEntity createGame(String playerName)
    {
        GameModel gameModel = new GameModel()
            .withStartTime(Timestamp.from(Instant.now()))
            .withState(GameState.STARTING);
        gameRepository.persist(gameModel);
        return converter.convertGameModelToEntity(gameModel);
    } 
}
