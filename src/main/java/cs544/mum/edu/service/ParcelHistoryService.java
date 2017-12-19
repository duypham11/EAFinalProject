package cs544.mum.edu.service;

import java.util.List;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelHistory;

public interface ParcelHistoryService {
	
	ParcelHistory save(ParcelHistory parcel);
	
	
	List<ParcelHistory> parcelHistoryByTrackNumber(String TrackNumber);
}
