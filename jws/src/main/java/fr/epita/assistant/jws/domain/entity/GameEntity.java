package fr.epita.assistant.jws.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class GameEntity {
    public Long id;
    public LocalDateTime startTime;
    public GameState state;
    public List<String> map;
    public List<PlayerEntity> players;
}
