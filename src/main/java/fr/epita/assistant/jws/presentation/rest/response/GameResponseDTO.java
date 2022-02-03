package fr.epita.assistant.jws.presentation.rest.response;

import java.security.Timestamp;

import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class GameResponseDTO {
    long id;
    Timestamp startTime;
    GameState state;
}
