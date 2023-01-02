package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.models.Voiture;
import ma.eheio.gestion_location.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;
    public List<Voiture> getAll()
    {
        return voitureRepository.findAll();
    }
    public void save(Voiture v)
    {
        voitureRepository.save(v);
    }
    public void delete(int id)
    {
        voitureRepository.deleteById(id);
    }
}
