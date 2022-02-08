package fr.epita.assistant.jws.presentation.rest.response;

import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class GameListResponseDTO {
    public Long id;
    public int players;
    public GameState state; 
}
