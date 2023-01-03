package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Client;
import ma.eheio.gestion_location.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll()
    {
        return clientRepository.findAll();
    }
    public void save(Client c)
    {
        clientRepository.save(c);
    }
    public void delete(int id)
    {
        clientRepository.deleteById(id);
    }
    public Client getById(int id)
    {
        return clientRepository.findById(id).orElseThrow();
    }
    public void update(Client c)
    {
        Client old=clientRepository.findById(c.getId()).orElseThrow();
        old.setCin(c.getCin());
        old.setNom(c.getNom());
        old.setPrenom(c.getPrenom());
        old.setSexe(c.getSexe());
        old.setAdresse(c.getAdresse());
        old.setEmail(c.getEmail());
        old.setTelephone(c.getTelephone());
        old.setDateNaiss(c.getDateNaiss());

        old.setLocations(c.getLocations());

        old.setLastModifiedDate(c.getLastModifiedDate());
        old.setLastModifiedBy(c.getLastModifiedBy());

        clientRepository.save(old);
    }
}
