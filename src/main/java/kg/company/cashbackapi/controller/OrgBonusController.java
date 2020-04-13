package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.OrgBonus;
import kg.company.cashbackapi.service.OrgBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orgBonus")
public class OrgBonusController {
    @Autowired
    OrgBonusService orgBonusService;

    @GetMapping("/{id}")
    public OrgBonus getOrgBonusById(@PathVariable("id") Long id) throws Exception {
        return orgBonusService.findById(id);
    }

    @GetMapping("/all")
    public List<OrgBonus> getAll() {
        return orgBonusService.findAll();
    }

    @PutMapping("/{id}")
    public OrgBonus putOrgBonus(@PathVariable("id") Long id, @RequestBody OrgBonus orgBonus) throws Exception {
        return orgBonusService.putById(id, orgBonus);
    }

    @PostMapping()
    public OrgBonus postOrgBonus(@RequestBody OrgBonus orgBonus) {
        orgBonusService.create(orgBonus);
        return orgBonus;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return orgBonusService.deleteById(id);
    }

}
