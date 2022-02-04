package fr.epita.assistant.jws.data.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity @Table(name = "player")
@AllArgsConstructor @NoArgsConstructor @With
public class PlayerModel {
    public @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    public Timestamp lastbomb;
    public Timestamp lastmovement;
    public int lives;
    public String name;
    public int posx;
    public int posy;
    public int position;
    public @ManyToOne GameModel game;
    
}
