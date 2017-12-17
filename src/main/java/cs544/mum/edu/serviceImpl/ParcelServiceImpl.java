package cs544.mum.edu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.repository.ParcelRepository;
import cs544.mum.edu.service.ParcelService;

@Service
public class ParcelServiceImpl implements ParcelService {
	
	@Autowired
	ParcelRepository parcelRepository;

	@Override
	public Parcel save(Parcel order) {
		return parcelRepository.save(order);
	}

	@Override
	public List<Parcel> getParcelsByRiderId(Long id) {
		return parcelRepository.listParcelsByRider(id);
	}

	@Override
	public Parcel find(Long id) {
		return parcelRepository.findOne(id);
	}

	@Override
	public List<Parcel> getParcelsByRiderAndStatus(Long riderId, Long statusId) {
		return parcelRepository.listParcelsByRiderAndStatus(riderId, statusId);
	}

	@Override
	public void update(Parcel order) {
		parcelRepository.save(order);
	}

	@Override
	public Parcel findByTrackNumber(String trackNumber) {
		return parcelRepository.parcelByTrackNumber(trackNumber);
	}
	
	@Override
	public List<Parcel> getParcelsByStoreId(Long id) {
		return parcelRepository.listParcelsByStore(id);
	}
	
	@Override
	public String getNextTrackNo() {
		return String.valueOf(parcelRepository.getNextTrackNo() + 1);
	};

}
