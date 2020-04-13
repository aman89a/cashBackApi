package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.PreferenceCategory;
import kg.company.cashbackapi.repository.PreferenceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceCategoryService {
    @Autowired
    private PreferenceCategoryRepository preferenceCategoryRepository;

    public PreferenceCategory findById(Long id) throws Exception {
        return preferenceCategoryRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<PreferenceCategory> findAll() {
        return preferenceCategoryRepository.findAll();
    }

    public PreferenceCategory create(PreferenceCategory preferenceCategory) {
        return preferenceCategoryRepository.save(preferenceCategory);
    }

    public String deleteById(Long id) {
        preferenceCategoryRepository.deleteById(id);
        return "PreferenceCategory number " + id + " has been deleted!";
    }

    public PreferenceCategory putById(Long id, PreferenceCategory preferenceCategory) throws Exception {
        return preferenceCategoryRepository.findById(id)
                .map(newPreferenceCategory -> {
                    newPreferenceCategory.setId(preferenceCategory.getId());
                    newPreferenceCategory.setName(preferenceCategory.getName());
                    newPreferenceCategory.setParent(preferenceCategory.getParent());
                    newPreferenceCategory.setType(preferenceCategory.getType());
                    return preferenceCategoryRepository.save(newPreferenceCategory);
                })
                .orElseThrow(Error::new);
    }


}
