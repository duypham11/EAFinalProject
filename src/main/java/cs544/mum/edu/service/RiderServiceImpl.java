package cs544.mum.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.mum.edu.dao.RiderDAO;
import cs544.mum.edu.domain.Rider;

@Service
public class RiderServiceImpl implements IRiderService{

	@Autowired
	private RiderDAO riderDAO;
	
	@Override
	public void createRider(Rider rider) {
		riderDAO.save(rider);
	}

	@Override
	public Rider getRider(long id) {
		return riderDAO.findOne(id);
	}

	@Override
	public Iterable<Rider> getAllRider() {
		return riderDAO.findAll();
	}

	@Override
	public void updateRider(Rider rider) {
		riderDAO.save(rider);
	}

	@Override
	public void deleteRider(long id) {
		riderDAO.delete(id);
	}

	@Override
	public void deleteRider(Rider rider) {
		riderDAO.delete(rider);
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
