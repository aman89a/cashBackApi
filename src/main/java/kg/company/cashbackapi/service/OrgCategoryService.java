package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.OrgCategory;
import kg.company.cashbackapi.repository.OrgCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgCategoryService {
    @Autowired
    private OrgCategoryRepository orgCategoryRepository;

    public OrgCategory findById(Long id) throws Exception {
        return orgCategoryRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<OrgCategory> findAll() {
        return orgCategoryRepository.findAll();
    }

    public OrgCategory create(OrgCategory orgCategory) {
        return orgCategoryRepository.save(orgCategory);
    }

    public String deleteById(Long id) {
        orgCategoryRepository.deleteById(id);
        return "OrgCategory number " + id + " has been deleted!";
    }

    public OrgCategory putById(Long id, OrgCategory orgCategory) throws Exception {
        return orgCategoryRepository.findById(id)
                .map(newOrgCategory -> {
                    newOrgCategory.setId(orgCategory.getId());
                    newOrgCategory.setDescription(orgCategory.getDescription());
                    newOrgCategory.setName(orgCategory.getName());
                    newOrgCategory.setImageUrl(orgCategory.getImageUrl());
                    newOrgCategory.setName(orgCategory.getName());
                    newOrgCategory.setTags(orgCategory.getTags());
                    return orgCategoryRepository.save(newOrgCategory);
                })
                .orElseThrow(Error::new);
    }


}
