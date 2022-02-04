package fr.epita.assistant.jws.presentation.rest.response;

import java.sql.Timestamp;

import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class GameResponseDTO {
    Long id;
    Timestamp starttime;
    GameState state;
}
