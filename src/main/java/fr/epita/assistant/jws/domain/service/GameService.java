package fr.epita.assistant.jws.domain.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.epita.assistant.jws.converter.Converter;
import fr.epita.assistant.jws.data.model.GameModel;
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

    public final List<GameEntity> getGames() {
        return gameRepository.findAll().stream()
        .map(model -> converter.convertGameModelToEntity(model))
        .collect(Collectors.toList());
    } 

    @Transactional
    public GameModel createGame(String playerName)
    {
        GameModel gameModel = new GameModel()
            .withStartTime(LocalDateTime.now())
            .withState(GameState.STARTING)
            .withMap("todo")
            .withPlayers(null);
        gameRepository.persist(gameModel);
            //TODO: Map function
            //TODO: Player function
        return gameModel;
    }
}

