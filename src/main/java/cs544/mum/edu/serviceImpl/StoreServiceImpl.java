package cs544.mum.edu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.mum.edu.domain.Store;
import cs544.mum.edu.domain.Role;
import cs544.mum.edu.domain.Username;
import cs544.mum.edu.repository.StoreRepository;
import cs544.mum.edu.repository.UsernameRepository;
import cs544.mum.edu.service.StoreService;


@Service
@Transactional 
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private UsernameRepository usernameRepository;

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save( Store restaurant) {  		
		storeRepository.save(restaurant);
	}


	@Override
//	@PreAuthorize("hasRole('ROLE_STORE')")
	public void saveFull( Store restaurant) {  	
		usernameRepository.save(restaurant.getUserCredentials());
		storeRepository.save(restaurant);
	}

	public List<Store> findAll() {
		return (List<Store>)storeRepository.findAll();
	}

	public Store findOne(Long id) {
		return storeRepository.findOne(id);
	}

	public List<Store> findByName(String name) {
		return (List<Store>) storeRepository.findByName(name);
	}

	public Store findByUsername(String username) {
		return storeRepository.findByUsername(username);
	}
	
	public List<Store> findStore() {
		return storeRepository.findStore();
	}
	public List<Store> findDisabledStore() {
		return storeRepository.findDisabledStore();
	}

}
