package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Location;
import ma.eheio.gestion_location.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    public List<Location> getAll()
    {
        return locationRepository.findAll();
    }

    public void save(Location r)
    {
        locationRepository.save(r);
    }
    public void delete(int id)
    {
        locationRepository.deleteById(id);
    }
    public Location getById(int id)
    {
        return locationRepository.findById(id).orElseThrow();
    }
    public void Update(Location l)
    {
        Location old=locationRepository.findById(l.getId()).orElseThrow();
        old.setDateDepart(l.getDateDepart());
        old.setDateRetoure(l.getDateRetoure());
        old.setTarif(l.getTarif());
        old.setLoue(l.isLoue());

        old.setClient(l.getClient());
        old.setVoiture(l.getVoiture());

        locationRepository.save(old);
    }
}
