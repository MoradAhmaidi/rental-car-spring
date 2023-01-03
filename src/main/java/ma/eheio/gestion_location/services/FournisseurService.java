package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Client;
import ma.eheio.gestion_location.models.Fournisseur;
import ma.eheio.gestion_location.repositories.ClientRepository;
import ma.eheio.gestion_location.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> getAll()
    {
        return fournisseurRepository.findAll();
    }
    public void save(Fournisseur f)
    {
        fournisseurRepository.save(f);
    }
    public void delete(int id)
    {
        fournisseurRepository.deleteById(id);
    }
    public Fournisseur getById(int id)
    {
        return fournisseurRepository.findById(id).orElseThrow();
    }
    public void update(Fournisseur f)
    {
        Fournisseur old=fournisseurRepository.findById(f.getId()).orElseThrow();
        old.setNom(f.getNom());
        old.setPrenom(f.getPrenom());
        old.setSexe(f.getSexe());
        old.setAdresse(f.getAdresse());
        old.setEmail(f.getEmail());
        old.setTelephone(f.getTelephone());
        old.setDateNaiss(f.getDateNaiss());

        old.setNumeFacteur(f.getNumeFacteur());
        old.setMaintenances(f.getMaintenances());

        old.setLastModifiedDate(f.getLastModifiedDate());
        old.setLastModifiedBy(f.getLastModifiedBy());

        fournisseurRepository.save(old);
    }
}
