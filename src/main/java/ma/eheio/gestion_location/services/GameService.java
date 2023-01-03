package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Game;
import ma.eheio.gestion_location.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll()
    {
        return gameRepository.findAll();
    }
    public void save(Game g)
    {
        gameRepository.save(g);
    }
    public void delete(int id)
    {
        gameRepository.deleteById(id);
    }
    public Game getById(int id)
    {
        return gameRepository.findById(id).orElseThrow();
    }
    public void update(Game c)
    {
        Game old=gameRepository.findById(c.getId()).orElseThrow();
        old.setLibelle(c.getLibelle());
        old.setDetails(c.getDetails());
        old.setNbrPortes(c.getNbrPortes());
        old.setNbrPassagers(c.getNbrPassagers());

        old.setModel(c.getModel());
        old.setVoitures(c.getVoitures());
        old.setCaractestiques(c.getCaractestiques());

        old.setLastModifiedDate(c.getLastModifiedDate());
        old.setLastModifiedBy(c.getLastModifiedBy());

        gameRepository.save(old);
    }

}
