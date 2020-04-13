package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.Filial;
import kg.company.cashbackapi.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilialService {
    @Autowired
    private FilialRepository filialRepository;

    public Filial findById(Long id) throws Exception {
        return filialRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Filial> findAll() {
        return filialRepository.findAll();
    }

    public Filial create(Filial filial) {
        return filialRepository.save(filial);
    }

    public String deleteById(Long id) {
        filialRepository.deleteById(id);
        return "Filial number " + id + " has been deleted!";
    }

    public Filial putById(Long id, Filial filial) throws Exception {
        return filialRepository.findById(id)
                .map(newFilial -> {
                    newFilial.setId(filial.getId());
                    newFilial.setDescription(filial.getDescription());
                    newFilial.setName(filial.getName());
                    newFilial.setAddress(filial.getAddress());
                    newFilial.setAverageRate(filial.getAverageRate());
                    newFilial.setLatitude(filial.getLatitude());
                    newFilial.setLongitude(filial.getLongitude());
                    newFilial.setStatus(filial.getStatus());
                    newFilial.setOrganization(filial.getOrganization());
                    newFilial.setCreatedDate(filial.getCreatedDate());
                    return filialRepository.save(newFilial);
                })
                .orElseThrow(Error::new);
    }


}
