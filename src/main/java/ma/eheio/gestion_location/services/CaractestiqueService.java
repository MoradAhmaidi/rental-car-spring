package ma.eheio.gestion_location.services;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.repositories.CaractestiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CaractestiqueService {
    @Autowired
    private CaractestiqueRepository caractestiqueRepository;

    public Page<Caractestique> getAll(int p,int s)
    {
        Pageable paging = PageRequest.of(p, s);
        return caractestiqueRepository.findAll(paging);
    }

    public void save(Caractestique c)
    {
        caractestiqueRepository.save(c);
    }
}
