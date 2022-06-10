package pl.sda.coursesproject.domain.role;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();

    }

    public Role getRoleById(Long id) {
        return roleRepository.getById(id);
    }


}
