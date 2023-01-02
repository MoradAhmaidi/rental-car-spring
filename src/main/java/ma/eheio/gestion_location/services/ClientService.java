package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
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
}
