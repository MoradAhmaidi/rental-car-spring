package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
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
}
