package cs544.mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.Rider;

public interface RiderRepository extends CrudRepository <Rider, Long> {

	public List<Rider> findRiderByfavZipCode(String zipCode);
	public List<Rider> findRiderByAddressPhone(String phone);
	public List<Rider> findRiderByEmail(String email);
	public List<Rider> findRiderByFirstName(String firstName);
	
	@Query(value = "SELECT * FROM Rider WHERE username = ?1", nativeQuery = true)
	public Rider findRiderByUsername(String userName);
	//public List<Parcel> getParcelList();
	
	@Query(value= "SELECT r.* FROM Rider r \n" + 
			"WHERE r.rider_id NOT IN (\n" + 
			"SELECT distinct p.rider_id \n" + 
			"FROM Parcel p \n" + 
			"WHERE p.status_id = 2\n" + 
			")" , nativeQuery = true)
	public List<Rider> getAvailableRider();

	@Query(value= "UPDATE rider SET count = ?1, rate = ?2 WHERE rider_Id = ?3", nativeQuery = true)
	public void updateRate(int count, float rate, Long id);

}
