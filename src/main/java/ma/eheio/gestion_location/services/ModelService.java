package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.models.Maintenance;
import ma.eheio.gestion_location.models.Model;
import ma.eheio.gestion_location.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;
    public List<Model> getAll()
    {
        return modelRepository.findAll();
    }
    public void save(Model m)
    {
        modelRepository.save(m);
    }
    public void delete(int id)
    {
        modelRepository.deleteById(id);
    }
    public Model getById(int id)
    {
        return modelRepository.findById(id).orElseThrow();
    }
    public void Update(Model m)
    {
        Model old=modelRepository.findById(m.getId()).orElseThrow();
        old.setLibelle(m.getLibelle());
        old.setDetails(m.getDetails());
        old.setPath(m.getPath());

        old.setGames(m.getGames());
        old.setMarque(m.getMarque());
        old.setCategorie(m.getCategorie());

        old.setLastModifiedDate(m.getLastModifiedDate());
        old.setLastModifiedBy(m.getLastModifiedBy());

        modelRepository.save(old);
    }
}
