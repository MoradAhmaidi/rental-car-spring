package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatistiqueService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private VoitureRepository voitureRepository;

    public int getUtilisateur()
    {
        return  utilisateurRepository.findAll().toArray().length;
    }
    public int getClient()
    {
        return  clientRepository.findAll().toArray().length;
    }
    public int getFournisseur()
    {
        return  fournisseurRepository.findAll().toArray().length;
    }
    public int getVoiture()
    {
        return  voitureRepository.findAll().toArray().length;
    }
    public int getReservation()
    {
        return  locationRepository.countAllByLoueIsFalse();
    }
    public int getLocation()
    {
        return  locationRepository.countAllByLoueIsTrue();
    }

}
