package cs544.mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs544.mum.edu.domain.Store;
import cs544.mum.edu.domain.Username;

@Repository
public interface StoreRepository extends CrudRepository<Store,Long> {
	@Query("SELECT s FROM Store s WHERE s.name LIKE CONCAT('%',:name,'%')")
	public List<Store> findByName(@Param("name") String name);
	
	@Query("SELECT s FROM Store s WHERE s.userCredentials.username =:username")
	public Store findByUsername(@Param("username") String username);
	@Query(value="select s.* from  Store s ,username u where a.username = u.username and u.enabled=1",nativeQuery = true)
	public List<Store> findStore();
	@Query(value="select s.* from  Store s ,username u where s.username = u.username and u.enabled!=1",nativeQuery = true)
	public List<Store> findDisabledStore();
}
