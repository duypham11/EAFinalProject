package cs544.mum.edu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import cs544.mum.edu.domain.Role;
import cs544.mum.edu.repository.RoleRepository;
import cs544.mum.edu.service.RoleService;

public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
}
