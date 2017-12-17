package cs544.mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cs544.mum.edu.domain.Rider;

public interface RiderRepository extends CrudRepository <Rider, Long> {

	List<Rider> findRiderByfavZipCode(String zipCode);
	List<Rider> findRiderByAddressPhone(String phoneNumber);
	List<Rider> findRiderByEmail(String email);
	List<Rider> findRiderByFirstName(String firstName);
	
	@Query(value= "SELECT r.* FROM Rider r \n" + 
			"WHERE r.rider_id NOT IN (\n" + 
			"SELECT distinct p.rider_id \n" + 
			"FROM Parcel p \n" + 
			"WHERE p.status_id = 2\n" + 
			")" , nativeQuery = true)
	public List<Rider> getAvailableRider();


}
