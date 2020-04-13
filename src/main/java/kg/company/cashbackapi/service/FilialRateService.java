package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.FilialRate;
import kg.company.cashbackapi.repository.FilialRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilialRateService {
    @Autowired
    private FilialRateRepository filialRateRepository;

    public FilialRate findById(Long id) throws Exception {
        return filialRateRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<FilialRate> findAll() {
        return filialRateRepository.findAll();
    }

    public FilialRate create(FilialRate filialRate) {
        return filialRateRepository.save(filialRate);
    }

    public String deleteById(Long id) {
        filialRateRepository.deleteById(id);
        return "FilialRate number " + id + " has been deleted!";
    }

    public FilialRate putById(Long id, FilialRate filialRate) throws Exception {
        return filialRateRepository.findById(id)
                .map(newFilialRate -> {
                    newFilialRate.setId(filialRate.getId());
                    newFilialRate.setClient(filialRate.getClient());
                    newFilialRate.setComment(filialRate.getComment());
                    newFilialRate.setFilial(filialRate.getFilial());
                    newFilialRate.setOrganization(filialRate.getOrganization());
                    newFilialRate.setRate(filialRate.getRate());
                    newFilialRate.setCreatedDate(filialRate.getCreatedDate());
                    return filialRateRepository.save(newFilialRate);
                })
                .orElseThrow(Error::new);
    }


}
