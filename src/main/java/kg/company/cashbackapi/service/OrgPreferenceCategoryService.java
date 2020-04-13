package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.OrgPreferenceCategory;
import kg.company.cashbackapi.repository.OrgPreferenceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgPreferenceCategoryService {
    @Autowired
    private OrgPreferenceCategoryRepository orgPreferenceCategoryRepository;

    public OrgPreferenceCategory findById(Long id) throws Exception {
        return orgPreferenceCategoryRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<OrgPreferenceCategory> findAll() {
        return orgPreferenceCategoryRepository.findAll();
    }

    public OrgPreferenceCategory create(OrgPreferenceCategory orgPreferenceCategory) {
        return orgPreferenceCategoryRepository.save(orgPreferenceCategory);
    }

    public String deleteById(Long id) {
        orgPreferenceCategoryRepository.deleteById(id);
        return "OrgPreferenceCategory number " + id + " has been deleted!";
    }

    public OrgPreferenceCategory putById(Long id, OrgPreferenceCategory orgPreferenceCategory) throws Exception {
        return orgPreferenceCategoryRepository.findById(id)
                .map(newOrgPreferenceCategory -> {
                    newOrgPreferenceCategory.setId(orgPreferenceCategory.getId());
                    newOrgPreferenceCategory.setOrganization(orgPreferenceCategory.getOrganization());
                    newOrgPreferenceCategory.setPreferenceCategory(orgPreferenceCategory.getPreferenceCategory());
                    return orgPreferenceCategoryRepository.save(newOrgPreferenceCategory);
                })
                .orElseThrow(Error::new);
    }


}
