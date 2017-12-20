package cs544.mum.edu.service;

import java.util.List;

import cs544.mum.edu.domain.Parcel;

public interface ParcelService {
	
	Parcel save(Parcel parcel);
	
	Parcel find(Long id);
	
	Parcel findByTrackNumber(String trackNumber); 
	
	List<Parcel> getParcelsByRiderId(Long id);
	
	List<Parcel> getParcelsByRiderAndStatus(Long riderId, Long statusId);
	
	//void update(Parcel parcel);
	
	List<Parcel> getParcelsByStoreId(Long id);
	
	String getNextTrackNo();
	List<Parcel> findParcelByParcelStatus(String status);
}
