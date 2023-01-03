package ma.eheio.gestion_location.services;

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
    public void delete(int id)
    {
        marqueRepository.deleteById(id);
    }
    public Marque getById(int id)
    {
        return marqueRepository.findById(id).orElseThrow();
    }
    public void update(Marque m)
    {
        Marque old=marqueRepository.findById(m.getId()).orElseThrow();
        old.setLibelle(m.getLibelle());
        old.setDetails(m.getDetails());
        old.setPath(m.getPath());

        old.setLastModifiedDate(m.getLastModifiedDate());
        old.setLastModifiedBy(m.getLastModifiedBy());

        marqueRepository.save(old);
    }
}
