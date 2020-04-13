package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.Organization;
import kg.company.cashbackapi.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;

    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable("id") Long id) throws Exception {
        return organizationService.findById(id);
    }

    @GetMapping("/all")
    public List<Organization> getAll() {
        return organizationService.findAll();
    }

    @PutMapping("/{id}")
    public Organization putOrganization(@PathVariable("id") Long id, @RequestBody Organization organization) throws Exception {
        return organizationService.putById(id, organization);
    }

    @PostMapping()
    public Organization postOrganization(@RequestBody Organization organization) {
        organizationService.create(organization);
        return organization;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return organizationService.deleteById(id);
    }

}
