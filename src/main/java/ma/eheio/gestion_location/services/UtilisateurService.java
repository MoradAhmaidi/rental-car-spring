package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
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
}
