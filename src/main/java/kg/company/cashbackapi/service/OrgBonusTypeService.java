package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.OrgBonusType;
import kg.company.cashbackapi.repository.OrgBonusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgBonusTypeService {
    @Autowired
    private OrgBonusTypeRepository orgBonusTypeRepository;

    public OrgBonusType findById(Long id) throws Exception {
        return orgBonusTypeRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<OrgBonusType> findAll() {
        return orgBonusTypeRepository.findAll();
    }

    public OrgBonusType create(OrgBonusType orgBonusType) {
        return orgBonusTypeRepository.save(orgBonusType);
    }

    public String deleteById(Long id) {
        orgBonusTypeRepository.deleteById(id);
        return "OrgBonusType number " + id + " has been deleted!";
    }

    public OrgBonusType putById(Long id, OrgBonusType orgBonusType) throws Exception {
        return orgBonusTypeRepository.findById(id)
                .map(newOrgBonusType -> {
                    newOrgBonusType.setId(orgBonusType.getId());
                    newOrgBonusType.setName(orgBonusType.getName());
                    newOrgBonusType.setValueType(orgBonusType.getValueType());
                    return orgBonusTypeRepository.save(newOrgBonusType);
                })
                .orElseThrow(Error::new);
    }


}
