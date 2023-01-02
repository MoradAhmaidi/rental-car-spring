package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.models.Marque;
import ma.eheio.gestion_location.repositories.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {
    @Autowired
    private MarqueRepository marqueRepository;
    public List<Marque> getAll()
    {
        return marqueRepository.findAll();
    }
    public void save(Marque m)
    {
        marqueRepository.save(m);
    }
}
