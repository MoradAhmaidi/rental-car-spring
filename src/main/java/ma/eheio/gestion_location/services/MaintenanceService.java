package ma.eheio.gestion_location.services;

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
    public void delete(int id)
    {
        maintenanceRepository.deleteById(id);
    }
    public Maintenance getById(int id)
    {
        return maintenanceRepository.findById(id).orElseThrow();
    }
    public void update(Maintenance m)
    {
        Maintenance old=maintenanceRepository.findById(m.getId()).orElseThrow();
        old.setLibelle(m.getLibelle());
        old.setDetails(m.getDetails());
        old.setTarif(m.getTarif());

        old.setVoiture(m.getVoiture());
        old.setFournisseur(m.getFournisseur());

        old.setLastModifiedDate(m.getLastModifiedDate());
        old.setLastModifiedBy(m.getLastModifiedBy());

        maintenanceRepository.save(old);
    }
}
