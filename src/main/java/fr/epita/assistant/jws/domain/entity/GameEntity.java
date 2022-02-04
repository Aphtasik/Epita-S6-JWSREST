package fr.epita.assistant.jws.domain.entity;

import java.sql.Timestamp;

import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class GameEntity {
    public Long id;
    public Timestamp startTime;
    public GameState state;
}
