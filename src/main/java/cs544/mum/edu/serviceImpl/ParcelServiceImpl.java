package cs544.mum.edu.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelHistory;
import cs544.mum.edu.repository.ParcelRepository;
import cs544.mum.edu.service.ParcelHistoryService;
import cs544.mum.edu.service.ParcelService;

@Service
public class ParcelServiceImpl implements ParcelService {
	
	@Autowired
	ParcelRepository parcelRepository;
	
	@Autowired
	ParcelService parcelService;
	
	@Autowired
	ParcelHistoryService parcelHistoryService;

	@Override
	public Parcel save(Parcel parcel) {
		//LogParcelHistory(parcel);
		return parcelRepository.save(parcel);
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

//	@Override
//	public void update(Parcel order) {
//		parcelRepository.save(order);
//	}

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
	}

	@Override
	public List<Parcel> findParcelByParcelStatus(String status) {
		return parcelRepository.findParcelByParcelStatus(status);
/*		List<Parcel> result = new ArrayList<Parcel>();
		for (Iterator<Parcel> iterParcel = parcelRepository.findAll().iterator(); iterParcel.hasNext();) {
			Parcel p = iterParcel.next();
			if (p.getStatus().getStatus().equals(status))
				result.add(p);
		}
		return result;*/
	}
	
	//alternative to AOP
	private void LogParcelHistory(Parcel parcel) {
		ParcelHistory ph = new ParcelHistory();
		
		//get current session user name to log
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ph.setModifiedBy(auth.getName());
		
		//get current status
		Parcel currentState = parcelService.find(parcel.getId());
		ph.setPreviousState(currentState.getStatus().getStatus());
		
		ph.setTrackingNO(parcel.getTrackNumber());
		ph.setCurrentState(parcel.getStatus().getStatus());
		
		parcelHistoryService.save(ph);
	}
	
}
