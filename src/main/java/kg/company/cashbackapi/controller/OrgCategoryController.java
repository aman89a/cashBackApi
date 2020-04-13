package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.OrgCategory;
import kg.company.cashbackapi.service.OrgCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orgCategory")
public class OrgCategoryController {
    @Autowired
    OrgCategoryService orgCategoryService;

    @GetMapping("/{id}")
    public OrgCategory getOrgCategoryById(@PathVariable("id") Long id) throws Exception {
        return orgCategoryService.findById(id);
    }

    @GetMapping("/all")
    public List<OrgCategory> getAll() {
        return orgCategoryService.findAll();
    }

    @PutMapping("/{id}")
    public OrgCategory putOrgCategory(@PathVariable("id") Long id, @RequestBody OrgCategory orgCategory) throws Exception {
        return orgCategoryService.putById(id, orgCategory);
    }

    @PostMapping()
    public OrgCategory postOrgCategory(@RequestBody OrgCategory orgCategory) {
        orgCategoryService.create(orgCategory);
        return orgCategory;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return orgCategoryService.deleteById(id);
    }

}
