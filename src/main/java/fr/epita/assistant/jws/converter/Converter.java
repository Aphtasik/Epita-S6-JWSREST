package fr.epita.assistant.jws.converter;

import javax.enterprise.context.ApplicationScoped;

import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.entity.PlayerEntity;

@ApplicationScoped
public class Converter {
    public GameEntity convertGameModelToEntity(GameModel model)
    {
        return new GameEntity(
            model.id,
            model.startTime,
            model.state
        );
    }

    public PlayerEntity convertPlayerModelToEntity(PlayerModel model)
    {
        return new PlayerEntity(
            model.id,
            model.lastbomb,
            model.lastmovement,
            model.lives,
            model.name,
            model.posx,
            model.posy,
            model.position
        );
    }
    
}
