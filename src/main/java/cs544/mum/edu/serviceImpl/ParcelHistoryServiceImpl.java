package cs544.mum.edu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.mum.edu.domain.ParcelHistory;
import cs544.mum.edu.repository.ParcelHistoryRepository;
import cs544.mum.edu.service.ParcelHistoryService;

@Service
public class ParcelHistoryServiceImpl implements ParcelHistoryService{

	@Autowired
	ParcelHistoryRepository parcelHistoryRepository;
	
	@Override
	@Transactional
	public ParcelHistory save(ParcelHistory parcelHistory) {
		return parcelHistoryRepository.save(parcelHistory);
		
	}

	@Override
	@Transactional
	public List<ParcelHistory> parcelHistoryByTrackNumber(String trackNumber) {
		// TODO Auto-generated method stub
		return parcelHistoryRepository.parcelHistoryByTrackingNumber(trackNumber);
	}
	
	
}
