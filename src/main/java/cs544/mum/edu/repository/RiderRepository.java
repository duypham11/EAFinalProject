package cs544.mum.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.ZipCode;

public interface RiderRepository extends CrudRepository <Rider, Long> {
<<<<<<< HEAD
	//List<Rider> findRiderByZipCode(String zipCode);
=======
	//TODO: cannot solve for now
	//@Query("SELECT r FROM Rider r WHERE r.favZipCode LIKE CONCAT('%',:zipcode,'%')")
	//List<Rider> findRiderByZipCode(@Param("zipcode") ZipCode zipCode);
>>>>>>> 3b80cff9d3c62f959c8fafe6add0f081354f2c0c
}
