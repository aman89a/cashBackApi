package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.OrgPreferenceCategory;
import kg.company.cashbackapi.service.OrgPreferenceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orgPreferenceCategory")
public class OrgPreferenceCategoryController {
    @Autowired
    OrgPreferenceCategoryService orgPreferenceCategoryService;

    @GetMapping("/{id}")
    public OrgPreferenceCategory getOrgPreferenceCategoryById(@PathVariable("id") Long id) throws Exception {
        return orgPreferenceCategoryService.findById(id);
    }

    @GetMapping("/all")
    public List<OrgPreferenceCategory> getAll() {
        return orgPreferenceCategoryService.findAll();
    }

    @PutMapping("/{id}")
    public OrgPreferenceCategory putOrgPreferenceCategory(@PathVariable("id") Long id, @RequestBody OrgPreferenceCategory orgPreferenceCategory) throws Exception {
        return orgPreferenceCategoryService.putById(id, orgPreferenceCategory);
    }

    @PostMapping()
    public OrgPreferenceCategory postOrgPreferenceCategory(@RequestBody OrgPreferenceCategory orgPreferenceCategory) {
        orgPreferenceCategoryService.create(orgPreferenceCategory);
        return orgPreferenceCategory;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return orgPreferenceCategoryService.deleteById(id);
    }

}
