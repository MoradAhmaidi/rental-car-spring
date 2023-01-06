package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Location;
import ma.eheio.gestion_location.repositories.LocationRepository;
import ma.eheio.gestion_location.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private VoitureService voitureService;
    public List<Location> getAll()
    {
        return locationRepository.findAll();
    }

    public void save(Location r)
    {
        long diffInMillies = Math.abs(r.getDateDepart().getTime() - r.getDateRetoure().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        r.setTarif(diff*voitureService.getById(r.getVoiture_id()).getTarif());
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
    public void update(Location l)
    {
        Location old=locationRepository.findById(l.getId()).orElseThrow();

        long diffInMillies = Math.abs(l.getDateDepart().getTime() - l.getDateRetoure().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        old.setTarif(diff*voitureService.getById(l.getVoiture_id()).getTarif());
        old.setDateDepart(l.getDateDepart());
        old.setDateRetoure(l.getDateRetoure());
        old.setTarif(l.getTarif());
        old.setLoue(l.isLoue());

        old.setClient(l.getClient());
        old.setVoiture(l.getVoiture());

        locationRepository.save(old);
    }
}
