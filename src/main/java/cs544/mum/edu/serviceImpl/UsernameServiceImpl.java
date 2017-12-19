package cs544.mum.edu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.mum.edu.domain.Username;
import cs544.mum.edu.repository.UsernameRepository;
import cs544.mum.edu.service.UsernameService;


@Service
@Transactional
public class UsernameServiceImpl implements UsernameService {

	
	@Autowired
	private UsernameRepository usernameRepository;

	@Override
	public Username findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Username disableOrEnable(Username username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int enableUser(String username) {
		return usernameRepository.updateEnableByUsername(username);
		
	}
	
}