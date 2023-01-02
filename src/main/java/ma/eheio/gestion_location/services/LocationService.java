package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Location;
import ma.eheio.gestion_location.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository reservationRepository;
    public List<Location> getAll()
    {
        return reservationRepository.findAll();
    }

    public void save(Location r)
    {
        reservationRepository.save(r);
    }
    public void delete(int id)
    {
        reservationRepository.deleteById(id);
    }
}
