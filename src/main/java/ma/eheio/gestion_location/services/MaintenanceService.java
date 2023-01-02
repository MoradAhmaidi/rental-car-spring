package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.models.Maintenance;
import ma.eheio.gestion_location.repositories.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<Maintenance> getAll()
    {
        return maintenanceRepository.findAll();
    }
    public void save(Maintenance m)
    {
        maintenanceRepository.save(m);
    }
}
