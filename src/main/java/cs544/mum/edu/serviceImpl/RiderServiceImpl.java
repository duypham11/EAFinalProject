package cs544.mum.edu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.repository.RiderRepository;
import cs544.mum.edu.service.IRiderService;

@Service
public class RiderServiceImpl implements IRiderService{

	@Autowired
	private RiderRepository riderRepository;
	
	@Override
	public void createRider(Rider rider) {
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
	public Rider findRiderByPhone(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Rider> findRidersByZipCode(String zipcode) {
		// TODO Auto-generated method stub
		return null;
	}

}
