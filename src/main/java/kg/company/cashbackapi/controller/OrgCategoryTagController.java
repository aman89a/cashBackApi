package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.OrgCategoryTag;
import kg.company.cashbackapi.service.OrgCategoryTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orgCategoryTag")
public class OrgCategoryTagController {
    @Autowired
    OrgCategoryTagService orgCategoryTagService;

    @GetMapping("/{id}")
    public OrgCategoryTag getOrgCategoryTagById(@PathVariable("id") Long id) throws Exception {
        return orgCategoryTagService.findById(id);
    }

    @GetMapping("/all")
    public List<OrgCategoryTag> getAll() {
        return orgCategoryTagService.findAll();
    }

    @PutMapping("/{id}")
    public OrgCategoryTag putOrgCategoryTag(@PathVariable("id") Long id, @RequestBody OrgCategoryTag orgCategoryTag) throws Exception {
        return orgCategoryTagService.putById(id, orgCategoryTag);
    }

    @PostMapping()
    public OrgCategoryTag postOrgCategoryTag(@RequestBody OrgCategoryTag orgCategoryTag) {
        orgCategoryTagService.create(orgCategoryTag);
        return orgCategoryTag;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return orgCategoryTagService.deleteById(id);
    }

}
