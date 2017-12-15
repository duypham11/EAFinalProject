package cs544.mum.edu.service;

import org.springframework.data.repository.CrudRepository;

import cs544.mum.edu.domain.Rider;

public interface RiderDAO extends CrudRepository <Rider, Long> {

}
