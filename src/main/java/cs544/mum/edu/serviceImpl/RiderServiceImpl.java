package cs544.mum.edu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.Store;
import cs544.mum.edu.repository.RiderRepository;
import cs544.mum.edu.repository.UsernameRepository;
import cs544.mum.edu.service.RiderService;

@Service
public class RiderServiceImpl implements RiderService{

	@Autowired
	private RiderRepository riderRepository;
	
	@Autowired
	UsernameRepository usernameRepository;
	
	@Override
	public void createRider(Rider rider) {
		//rider.getUserCredentials().setEnabled(true);
		usernameRepository.save(rider.getUserCredentials());
		riderRepository.save(rider);
	}

	@Override
	public Rider getRider(long id) {
		return riderRepository.findOne(id);
	}

	@Override
	public Iterable<Rider> getAllRider() {
		return riderRepository.findAll();
	}

	@Override
	public void updateRider(Rider rider) {
		//rider.getUserCredentials().setEnabled(true);
		usernameRepository.save(rider.getUserCredentials());
		riderRepository.save(rider);
	}

	@Override
	public void saveRider(Rider rider) {
		riderRepository.save(rider);
	}
	
	@Override
	public void deleteRider(long id) {
		riderRepository.delete(id);
	}

	@Override
	public void deleteRider(Rider rider) {
		riderRepository.delete(rider);
	}

	@Override
	public Iterable<Rider> findRiderByPhone(String phoneNumber) {
		return riderRepository.findRiderByAddressPhone(phoneNumber);
	}

	@Override
	public Iterable<Rider> findRidersByFavZipCode(String zipCode) {
		return riderRepository.findRiderByfavZipCode(zipCode);
	}

	@Override
	public Iterable<Rider> findRiderByEmail(String email) {
		return riderRepository.findRiderByEmail(email);
	}

	@Override
	public Iterable<Rider> findRiderByFirstName(String firstName) {
		return riderRepository.findRiderByFirstName(firstName);
	}
	
	@Override
	public List<Rider> getAvailableRider() {
		return (List<Rider>) riderRepository.getAvailableRider();
	}

	@Override
	public Rider findRiderByUserName(String userName) {
		//riderRepository.getAvailableRider()
		return riderRepository.findRiderByUsername(userName);
	}

	public List<Rider> findAll() {
		return (List<Rider>)riderRepository.findAll();
	}

	@Override
	public void updateRate(int rate, Rider rider) {
		
		int count = rider.getRateObj().getCount();
		float rate2 = ((rider.getRate() * count) + rate)/(count+1);
		count++;
		riderRepository.updateRate(count, rate2, rider.getRider_Id());
		
		
	}
}
