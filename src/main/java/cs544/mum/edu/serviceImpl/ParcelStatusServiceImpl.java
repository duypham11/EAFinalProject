package cs544.mum.edu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.mum.edu.domain.ParcelStatus;
import cs544.mum.edu.repository.ParcelStatusRepository;
import cs544.mum.edu.service.ParcelStatusService;

@Service
public class ParcelStatusServiceImpl implements ParcelStatusService{
	@Autowired
	ParcelStatusRepository parcelStatusRepository;

	@Override
	public ParcelStatus find(Long id) {
		return parcelStatusRepository.findOne(id);
	}

	@Override
	public ParcelStatus findByStatus(String status) {
		// TODO Auto-generated method stub
		return parcelStatusRepository.findParcelStatusByStatus(status);
	}
}
