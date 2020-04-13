package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.OrgCategoryTag;
import kg.company.cashbackapi.repository.OrgCategoryTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgCategoryTagService {
    @Autowired
    private OrgCategoryTagRepository orgCategoryTagRepository;

    public OrgCategoryTag findById(Long id) throws Exception {
        return orgCategoryTagRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<OrgCategoryTag> findAll() {
        return orgCategoryTagRepository.findAll();
    }

    public OrgCategoryTag create(OrgCategoryTag orgCategoryTag) {
        return orgCategoryTagRepository.save(orgCategoryTag);
    }

    public String deleteById(Long id) {
        orgCategoryTagRepository.deleteById(id);
        return "OrgCategoryTag number " + id + " has been deleted!";
    }

    public OrgCategoryTag putById(Long id, OrgCategoryTag orgCategoryTag) throws Exception {
        return orgCategoryTagRepository.findById(id)
                .map(newOrgCategoryTag -> {
                    newOrgCategoryTag.setId(orgCategoryTag.getId());
                    newOrgCategoryTag.setName(orgCategoryTag.getName());
                    newOrgCategoryTag.setName(orgCategoryTag.getName());
                    return orgCategoryTagRepository.save(newOrgCategoryTag);
                })
                .orElseThrow(Error::new);
    }


}
