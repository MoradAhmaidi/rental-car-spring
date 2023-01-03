package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.models.Maintenance;
import ma.eheio.gestion_location.models.Utilisateur;
import ma.eheio.gestion_location.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    public List<Utilisateur> getAll()
    {
        return utilisateurRepository.findAll();
    }
    public void save(Utilisateur u)
    {
        utilisateurRepository.save(u);
    }
    public void delete(int id)
    {
        utilisateurRepository.deleteById(id);
    }
    public Utilisateur getById(int id)
    {
        return utilisateurRepository.findById(id).orElseThrow();
    }
    public void Update(Utilisateur u)
    {
        Utilisateur old=utilisateurRepository.findById(u.getId()).orElseThrow();
        old.setLogin(u.getLogin());
        old.setMotDePass(u.getMotDePass());
        old.setRole(u.getRole());
        old.setPath(u.getPath());
        old.setNom(u.getNom());
        old.setPrenom(u.getPrenom());
        old.setSexe(u.getSexe());
        old.setAdresse(u.getAdresse());
        old.setEmail(u.getEmail());
        old.setTelephone(u.getTelephone());
        old.setDateNaiss(u.getDateNaiss());

        old.setLastModifiedDate(u.getLastModifiedDate());
        old.setLastModifiedBy(u.getLastModifiedBy());

        utilisateurRepository.save(old);
    }
}
