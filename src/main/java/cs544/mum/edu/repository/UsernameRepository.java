package cs544.mum.edu.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs544.mum.edu.domain.Username;


@Repository
public interface UsernameRepository extends CrudRepository<Username,String> {
  
	@Query("SELECT u from Username u WHERE u.username = :username")
	public Username findByUsername(@Param("username")String username);
	@Modifying
	@Transactional
	@Query("UPDATE Username c SET c.enabled = 0 WHERE c.username=:username")
	public int updateEnableByUsername(@Param("username") String username);
}
