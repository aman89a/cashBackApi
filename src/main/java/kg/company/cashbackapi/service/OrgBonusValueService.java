package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.OrgBonusValue;
import kg.company.cashbackapi.repository.OrgBonusValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgBonusValueService {
    @Autowired
    private OrgBonusValueRepository orgBonusValueRepository;

    public OrgBonusValue findById(Long id) throws Exception {
        return orgBonusValueRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<OrgBonusValue> findAll() {
        return orgBonusValueRepository.findAll();
    }

    public OrgBonusValue create(OrgBonusValue orgBonusValue) {
        return orgBonusValueRepository.save(orgBonusValue);
    }

    public String deleteById(Long id) {
        orgBonusValueRepository.deleteById(id);
        return "OrgBonusValue number " + id + " has been deleted!";
    }

    public OrgBonusValue putById(Long id, OrgBonusValue orgBonusValue) throws Exception {
        return orgBonusValueRepository.findById(id)
                .map(newOrgBonusValue -> {
                    newOrgBonusValue.setId(orgBonusValue.getId());
                    newOrgBonusValue.setMax(orgBonusValue.getMax());
                    newOrgBonusValue.setMin(orgBonusValue.getMin());
                    newOrgBonusValue.setOrgBonus(orgBonusValue.getOrgBonus());
                    newOrgBonusValue.setValue(orgBonusValue.getValue());
                    return orgBonusValueRepository.save(newOrgBonusValue);
                })
                .orElseThrow(Error::new);
    }


}
