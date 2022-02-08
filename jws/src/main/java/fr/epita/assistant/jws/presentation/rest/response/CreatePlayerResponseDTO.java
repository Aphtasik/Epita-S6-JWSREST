package fr.epita.assistant.jws.presentation.rest.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class CreatePlayerResponseDTO {
    public Long id;
    public String name;
    public int lives;
    public int posX;
    public int posY;
}
