package cs544.mum.edu.service;

import cs544.mum.edu.domain.Rider;

public interface RiderService {
	void createRider(Rider rider);
	Rider getRider(long id);
	Iterable<Rider> getAllRider();
	void updateRider(Rider rider);
	void deleteRider(long id);
	void deleteRider(Rider rider);
	Rider findRiderByPhone(String phoneNumber);
	Iterable<Rider> findRidersByZipCode(String zipcode);
}
