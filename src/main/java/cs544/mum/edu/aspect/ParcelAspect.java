package cs544.mum.edu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelHistory;
import cs544.mum.edu.service.ParcelHistoryService;
import cs544.mum.edu.service.ParcelService;

@Component
@Aspect
@EnableAspectJAutoProxy
public class ParcelAspect {
	@Autowired
	ParcelHistoryService parcelHistoryService;
	
	@Autowired
	ParcelService parcelService;
	
	@Before("execution(public * cs544.mum.edu.service.ParcelService.save(..))")
	public void updateParcelHistory(JoinPoint joinpoint){
		System.out.println("AOP running");
		Object[] args = joinpoint.getArgs();
		Parcel parcel = (Parcel) args[0];
		System.out.println("Executing save on parcel" + parcel);
		
		ParcelHistory ph = new ParcelHistory();
		
		//get current session user name to log
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ph.setModifiedBy(auth.getName());
		
		//get current status
		if(parcel.getId() != null) {
			//existing request with only status update
			Parcel currentState = parcelService.find(parcel.getId());
			ph.setPreviousState(currentState.getStatus().getStatus());
			ph.setCurrentState(parcel.getStatus().getStatus());
		}else {
			//new create request
			ph.setPreviousState("INIT");
			ph.setCurrentState("NEW");
		}
		
		ph.setTrackingNO(parcel.getTrackNumber());
		
		parcelHistoryService.save(ph);
	}

}
