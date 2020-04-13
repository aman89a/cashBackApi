package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.Role;
import kg.company.cashbackapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable("id") Long id) throws Exception {
        return roleService.findById(id);
    }

    @GetMapping("/all")
    public List<Role> getAll() {
        return roleService.findAll();
    }

    @PutMapping("/{id}")
    public Role putRole(@PathVariable("id") Long id, @RequestBody Role role) throws Exception {
        return roleService.putById(id, role);
    }

    @PostMapping()
    public Role postRole(@RequestBody Role role) {
        roleService.create(role);
        return role;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return roleService.deleteById(id);
    }

}
