package fr.epita.assistant.jws.data.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity @Table(name = "game")
@AllArgsConstructor @NoArgsConstructor @With
public class GameModel {
    public @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    public Timestamp startTime;
    public GameState state;
}
