package cs544.mum.edu.repository;

import org.springframework.data.repository.CrudRepository;

import cs544.mum.edu.domain.Rider;

public interface RiderRepository extends CrudRepository <Rider, Long> {

	//List<Rider> findRiderByZipCode(String zipCode);
}
