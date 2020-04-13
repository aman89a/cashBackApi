package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.PreferenceCategory;
import kg.company.cashbackapi.service.PreferenceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/preferenceCategory")
public class PreferenceCategoryController {
    @Autowired
    PreferenceCategoryService preferenceCategoryService;

    @GetMapping("/{id}")
    public PreferenceCategory getPreferenceCategoryById(@PathVariable("id") Long id) throws Exception {
        return preferenceCategoryService.findById(id);
    }

    @GetMapping("/all")
    public List<PreferenceCategory> getAll() {
        return preferenceCategoryService.findAll();
    }

    @PutMapping("/{id}")
    public PreferenceCategory putPreferenceCategory(@PathVariable("id") Long id, @RequestBody PreferenceCategory preferenceCategory) throws Exception {
        return preferenceCategoryService.putById(id, preferenceCategory);
    }

    @PostMapping()
    public PreferenceCategory postPreferenceCategory(@RequestBody PreferenceCategory preferenceCategory) {
        preferenceCategoryService.create(preferenceCategory);
        return preferenceCategory;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return preferenceCategoryService.deleteById(id);
    }

}
