package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.models.Categorie;
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
}
