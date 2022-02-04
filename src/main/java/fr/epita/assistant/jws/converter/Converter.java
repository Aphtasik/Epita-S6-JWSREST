/*package fr.epita.assistant.jws.converter;

import javax.enterprise.context.ApplicationScoped;

import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.entity.PlayerEntity;
import fr.epita.assistant.jws.presentation.rest.response.GameDetailResponseDTO;

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

    public GameDetailResponseDTO convertGameEntityToDetailResponseDTO(GameEntity entity)
    {
        return new GameDetailResponseDTO(
            entity.id,
            entity.startTime,
            entity.state
        );
    }

    public GameDetailResponseDTO.PlayerResponseDTO convertPlayerEntityPlayerResponseDTO(PlayerEntity entity)
    {
        return new GameDetailResponseDTO.PlayerResponseDTO(
            entity.id,
            entity.lastbomb,
            entity.lastmovement,
            entity.lives,
            entity.name,
            entity.posx,
            entity.posy,
            entity.position
        );
    }
    
}*/
