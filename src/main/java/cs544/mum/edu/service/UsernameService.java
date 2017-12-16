package cs544.mum.edu.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cs544.mum.edu.domain.Store;
import cs544.mum.edu.domain.Username;;

public interface UsernameService {
 	public Username findByUsername(String username);
 	public Username disableOrEnable(Username username);
 
}
