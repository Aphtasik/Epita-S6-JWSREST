package fr.epita.assistant.jws.converter;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.entity.PlayerEntity;
import fr.epita.assistant.jws.domain.service.GameService;
import fr.epita.assistant.jws.presentation.rest.request.CreateGameRequestDTO;
import fr.epita.assistant.jws.presentation.rest.response.CreateGameResponseDTO;
import fr.epita.assistant.jws.presentation.rest.response.CreatePlayerResponseDTO;
import fr.epita.assistant.jws.presentation.rest.response.GameListResponseDTO;

@ApplicationScoped
public class Converter {

    @Inject GameService gameService;

    public PlayerEntity convertPlayerModelToEntity(PlayerModel model)
    {
        return new PlayerEntity(
            model.id,
            model.lastBomb,
            model.lastMovement,
            model.lives,
            model.name,
            model.posx,
            model.posy
        );
    }

    public GameEntity convertGameModelToEntity(GameModel model)
    {
        return new GameEntity(
            model.id,
            model.startTime,
            model.state,
            gameService.mapStringToList(model.map),
            model.players.stream().map(player -> convertPlayerModelToEntity(player)).collect(Collectors.toList())
        );
    }

    public CreatePlayerResponseDTO convertPlayerEntityToCreateResponse(PlayerEntity entity) {
        return new CreatePlayerResponseDTO(
            entity.id,
            entity.name,
            entity.lives,
            entity.posx,
            entity.posy
        );

    }
    public CreateGameResponseDTO convertGameEntityToCreateResponse(GameEntity entity)
    {
        return new CreateGameResponseDTO(
            entity.startTime,
            entity.state,
            entity.players.stream().map(player -> convertPlayerEntityToCreateResponse(player)).collect(Collectors.toList()),
            entity.map,
            entity.id
        );
    }

    public GameListResponseDTO convertGameEntityToGameListReponse(GameEntity entity)
    {
        return new GameListResponseDTO(
            entity.id,
            entity.players.size(),
            entity.state
        );
    }
}
