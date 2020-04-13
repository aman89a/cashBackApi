package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.OrgBonusType;
import kg.company.cashbackapi.service.OrgBonusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orgBonusType")
public class OrgBonusTypeController {
    @Autowired
    OrgBonusTypeService orgBonusTypeService;

    @GetMapping("/{id}")
    public OrgBonusType getOrgBonusTypeById(@PathVariable("id") Long id) throws Exception {
        return orgBonusTypeService.findById(id);
    }

    @GetMapping("/all")
    public List<OrgBonusType> getAll() {
        return orgBonusTypeService.findAll();
    }

    @PutMapping("/{id}")
    public OrgBonusType putOrgBonusType(@PathVariable("id") Long id, @RequestBody OrgBonusType orgBonusType) throws Exception {
        return orgBonusTypeService.putById(id, orgBonusType);
    }

    @PostMapping()
    public OrgBonusType postOrgBonusType(@RequestBody OrgBonusType orgBonusType) {
        orgBonusTypeService.create(orgBonusType);
        return orgBonusType;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return orgBonusTypeService.deleteById(id);
    }

}
