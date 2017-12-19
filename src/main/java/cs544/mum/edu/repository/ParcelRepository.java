package cs544.mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs544.mum.edu.domain.Parcel;

@Repository
public interface ParcelRepository extends CrudRepository<Parcel, Long> {
	
	@Query(value = "SELECT * FROM Parcel p, ParcelStatus ps where p.status_id = ps.id and ps.status like ?1", nativeQuery = true)
	public List<Parcel> findParcelByParcelStatus(String status);
	
	@Query(value = "SELECT * FROM Parcel WHERE rider_id = ?1", nativeQuery = true)
	public List<Parcel> listParcelsByRider(Long id);
	
	@Query(value = "SELECT * FROM Parcel WHERE rider_id = ?1 AND status_id = ?2", nativeQuery = true)
	public List<Parcel> listParcelsByRiderAndStatus(Long riderId, Long statusId);
	
	@Query(value = "SELECT * FROM Parcel WHERE trackNumber = ?1", nativeQuery = true)
	public Parcel parcelByTrackNumber(String trackNumber);
	
	@Query(value="SELECT * FROM Parcel WHERE store_id = ?1 ", nativeQuery = true)
	public List<Parcel> listParcelsByStore(@Param("id") Long id);
	
	@Query(value="SELECT tracKNumber FROM Parcel order by tracKNumber desc limit 1;", nativeQuery = true)
	public int getNextTrackNo();

}
