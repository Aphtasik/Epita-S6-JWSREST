package fr.epita.assistant.jws.data.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity @Table(name = "game")
@AllArgsConstructor @NoArgsConstructor @With
public class GameModel {
    public @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    public LocalDateTime startTime;
    public GameState state;
    public @Column(columnDefinition = "TEXT") String map;
    public @OneToMany(cascade = CascadeType.ALL) List<PlayerModel> players;
}
