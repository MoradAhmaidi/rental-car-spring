package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caracteristique;
import ma.eheio.gestion_location.repositories.CaracteristiquesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CaracteristiquesService {
    @Autowired
    private CaracteristiquesRepository caracteristiquesRepository;

    public Page<Caracteristique> getAll(int p, int s)
    {
        Pageable paging = PageRequest.of(p, s);
        return caracteristiquesRepository.findAll(paging);
    }

    public void save(Caracteristique c)
    {
        caracteristiquesRepository.save(c);
    }
    public void delete(int id)
    {
        caracteristiquesRepository.deleteById(id);
    }
    public Caracteristique getById(int id)
    {
        return caracteristiquesRepository.findById(id).orElseThrow();
    }
    public void update(Caracteristique c)
    {
       Caracteristique old= caracteristiquesRepository.findById(c.getId()).orElseThrow();
       old.setLibelle(c.getLibelle());
       old.setDetails(c.getDetails());
       old.setGames(c.getGames());

       old.setLastModifiedDate(c.getLastModifiedDate());
       old.setLastModifiedBy(c.getLastModifiedBy());

       caracteristiquesRepository.save(old);

    }
}
