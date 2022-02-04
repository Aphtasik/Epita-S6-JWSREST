package fr.epita.assistant.jws.converter;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.entity.PlayerEntity;

@ApplicationScoped
public class Converter {

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
            model.map,
            model.players.stream().map(player -> convertPlayerModelToEntity(player)).collect(Collectors.toList())
        );
    }
}
