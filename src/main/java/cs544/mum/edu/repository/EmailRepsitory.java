package cs544.mum.edu.repository;

import org.springframework.data.repository.CrudRepository;

import cs544.mum.edu.domain.Email;

public interface EmailRepsitory  extends CrudRepository<Email,Long>{

}
