package fr.epita.assistant.jws.domain.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class PlayerEntity {
    public Long id;
    public Timestamp lastbomb;
    public Timestamp lastmovement;
    public int lives;
    public String name;
    public int posx;
    public int posy;
    public int position;
}