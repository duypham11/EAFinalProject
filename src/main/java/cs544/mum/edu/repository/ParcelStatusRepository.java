package cs544.mum.edu.repository;

import org.springframework.data.repository.CrudRepository;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelStatus;

public interface ParcelStatusRepository extends CrudRepository<ParcelStatus, Long>{
	public ParcelStatus findParcelStatusByStatus(String status);
}
