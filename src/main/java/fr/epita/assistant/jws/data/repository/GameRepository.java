package fr.epita.assistant.jws.data.repository;

import javax.enterprise.context.ApplicationScoped;

import fr.epita.assistant.jws.data.model.GameModel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class GameRepository implements PanacheRepositoryBase<GameModel, Long> {
    
}
