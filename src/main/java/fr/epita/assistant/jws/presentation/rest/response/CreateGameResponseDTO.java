package fr.epita.assistant.jws.presentation.rest.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import fr.epita.assistant.jws.domain.entity.PlayerEntity;
import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class CreateGameResponseDTO {
    public LocalDateTime startTime;
    public GameState state;
    public List<CreatePlayerResponseDTO> players;
    public List<String> map;
    public Long id;
}
