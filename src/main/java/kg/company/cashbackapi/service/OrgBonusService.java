package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.OrgBonus;
import kg.company.cashbackapi.repository.OrgBonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgBonusService {
    @Autowired
    private OrgBonusRepository orgBonusRepository;

    public OrgBonus findById(Long id) throws Exception {
        return orgBonusRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<OrgBonus> findAll() {
        return orgBonusRepository.findAll();
    }

    public OrgBonus create(OrgBonus orgBonus) {
        return orgBonusRepository.save(orgBonus);
    }

    public String deleteById(Long id) {
        orgBonusRepository.deleteById(id);
        return "OrgBonus number " + id + " has been deleted!";
    }

    public OrgBonus putById(Long id, OrgBonus orgBonus) throws Exception {
        return orgBonusRepository.findById(id)
                .map(newOrgBonus -> {
                    newOrgBonus.setId(orgBonus.getId());
                    newOrgBonus.setCreatedDate(orgBonus.getCreatedDate());
                    newOrgBonus.setOrganization(orgBonus.getOrganization());
                    newOrgBonus.setValidity(orgBonus.getValidity());
                    newOrgBonus.setValidFrom(orgBonus.getValidFrom());
                    newOrgBonus.setStatus(orgBonus.getStatus());
                    newOrgBonus.setDeletedDate(orgBonus.getDeletedDate());
                    newOrgBonus.setOrgBonusType(orgBonus.getOrgBonusType());
                    newOrgBonus.setValidTo(orgBonus.getValidTo());
                    return orgBonusRepository.save(newOrgBonus);
                })
                .orElseThrow(Error::new);
    }


}
