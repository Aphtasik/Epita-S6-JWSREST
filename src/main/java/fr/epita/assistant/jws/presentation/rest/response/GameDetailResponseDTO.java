package fr.epita.assistant.jws.presentation.rest.response;

import java.sql.Timestamp;

import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class GameDetailResponseDTO {
    public Long id;
    public Timestamp startTime;
    public GameState state;

    @AllArgsConstructor @NoArgsConstructor
    public static class PlayerResponseDTO
    {
        public Long id;
        public Timestamp lastbomb;
        public Timestamp lastmovement;
        public int lives;
        public String name;
        public int posx;
        public int posy;
        public int position;
    }
}
