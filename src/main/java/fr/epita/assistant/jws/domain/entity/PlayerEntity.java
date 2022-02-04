package fr.epita.assistant.jws.domain.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class PlayerEntity {
    public Long id;
    public LocalDateTime lastBomb;
    public LocalDateTime lastMovement;
    public int lives;
    public String name;
    public int posx;
    public int posy;
}
