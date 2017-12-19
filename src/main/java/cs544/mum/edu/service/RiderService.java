package cs544.mum.edu.service;

import java.util.List;

import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.Store;

public interface RiderService {
	
	public List<Rider> findAll();
	void createRider(Rider rider);
	Rider getRider(long id);
	Iterable<Rider> getAllRider();
	void updateRider(Rider rider);
	void deleteRider(long id);
	void deleteRider(Rider rider);
	Iterable<Rider> findRiderByPhone(String phoneNumber);
	Iterable<Rider> findRidersByFavZipCode(String zipcode);
	Iterable<Rider> findRiderByEmail(String email);
	Iterable<Rider> findRiderByFirstName(String firstName);
	Rider findRiderByUserName(String userName);

	List<Rider> getAvailableRider();

}
