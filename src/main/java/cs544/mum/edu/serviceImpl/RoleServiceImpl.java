package cs544.mum.edu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.mum.edu.domain.Role;
import cs544.mum.edu.repository.RoleRepository;
import cs544.mum.edu.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}
	
}
