package cs544.mum.edu.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cs544.mum.edu.domain.Rider;

public interface RiderDAO extends CrudRepository <Rider, Long> {
	List<Rider> findRiderByZipCode(String zipCode);
}
