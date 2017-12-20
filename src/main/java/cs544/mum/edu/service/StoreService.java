package cs544.mum.edu.service;

import java.util.List;

import cs544.mum.edu.domain.Store;
import cs544.mum.edu.domain.Username;;
 
public interface StoreService {

	public void save(Store store);
    	public void saveFull( Store store);  		
	public List<Store> findAll();
 	public Store findOne(Long id);
 	public Store findByUsername(String username);
	public List<Store> findByName(String name);
	public List<Store> findStore();
	public List<Store> findDisabledStore() ;
 
}
