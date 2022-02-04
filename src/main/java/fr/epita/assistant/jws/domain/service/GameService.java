package fr.epita.assistant.jws.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.data.repository.GameRepository;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.converter.Converter;

@ApplicationScoped
public class GameService {
    @Inject GameRepository gameRepository;
    @Inject Converter converter;

    public List<GameEntity> getAllGames() {
        var games = gameRepository.findAll();
        return games.stream().map(game -> converter.convertGameModelToEntity(game)).collect(Collectors.toList());
    }

    @Transactional
    public GameEntity createGame(String playerName)
    {
        return null;
    } 
}
