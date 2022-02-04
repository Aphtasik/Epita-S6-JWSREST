package fr.epita.assistant.jws.data.repository;

import javax.enterprise.context.ApplicationScoped;

import fr.epita.assistant.jws.data.model.PlayerModel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class PlayerRepository implements PanacheRepositoryBase<PlayerModel, Long> {
    
}
