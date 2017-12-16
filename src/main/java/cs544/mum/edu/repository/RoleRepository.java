package cs544.mum.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs544.mum.edu.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
