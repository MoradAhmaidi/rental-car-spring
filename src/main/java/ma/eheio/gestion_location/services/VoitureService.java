package ma.eheio.gestion_location.services;

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
    public Voiture getById(int id)
    {
        return voitureRepository.findById(id).orElseThrow();
    }
    public void update(Voiture v)
    {
        Voiture old=voitureRepository.findById(v.getId()).orElseThrow();
        old.setMatricule(v.getMatricule());
        old.setNChassis(v.getNChassis());
        old.setCarburant(v.getCarburant());
        old.setBoiteVitesse(v.getBoiteVitesse());
        old.setPuissance(v.getPuissance());
        old.setColor(v.getColor());
        old.setEtat(v.getEtat());
        old.setKilometrage(v.getKilometrage());
        old.setDisponibilite(v.isDisponibilite());
        old.setPath(v.getPath());
        old.setGame(v.getGame());
        old.setMaintenances(v.getMaintenances());
        old.setLocation(v.getLocation());

        old.setLastModifiedDate(v.getLastModifiedDate());
        old.setLastModifiedBy(v.getLastModifiedBy());

        voitureRepository.save(old);
    }
}
