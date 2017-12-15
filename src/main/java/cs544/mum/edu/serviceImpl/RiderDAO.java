package cs544.mum.edu.serviceImpl;

import org.springframework.data.repository.CrudRepository;

import cs544.mum.edu.domain.Rider;

public interface RiderDAO extends CrudRepository <Rider, Long> {

}
