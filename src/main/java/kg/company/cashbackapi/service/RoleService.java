package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.Role;
import kg.company.cashbackapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Long id) throws Exception {
        return roleRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public String deleteById(Long id) {
        roleRepository.deleteById(id);
        return "Role number " + id + " has been deleted!";
    }

    public Role putById(Long id, Role role) throws Exception {
        return roleRepository.findById(id)
                .map(newRole -> {
                    newRole.setId(role.getId());
                    newRole.setDescription(role.getDescription());
                    newRole.setName(role.getName());
                    return roleRepository.save(newRole);
                })
                .orElseThrow(Error::new);
    }


}
