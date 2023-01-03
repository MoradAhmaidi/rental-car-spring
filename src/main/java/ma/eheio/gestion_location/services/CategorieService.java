package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.models.Categorie;
import ma.eheio.gestion_location.models.Maintenance;
import ma.eheio.gestion_location.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    public List<Categorie> getAll()
    {
        return categorieRepository.findAll();
    }

    public void save(Categorie c)
    {
         categorieRepository.save(c);
    }
    public void delete(int id)
    {
        categorieRepository.deleteById(id);
    }
    public Categorie getById(int id)
    {
        return categorieRepository.findById(id).orElseThrow();
    }
    public void Update(Categorie c)
    {
        Categorie old=categorieRepository.findById(c.getId()).orElseThrow();
        old.setLibelle(c.getLibelle());
        old.setDetails(c.getDetails());
        old.setPath(c.getPath());
        old.setLastModifiedDate(c.getLastModifiedDate());
        old.setLastModifiedBy(c.getLastModifiedBy());

        categorieRepository.save(old);

    }
}
