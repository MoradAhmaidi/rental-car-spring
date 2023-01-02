package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
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
}
