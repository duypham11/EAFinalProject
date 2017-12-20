package cs544.mum.edu.service;

import cs544.mum.edu.domain.Username;;

public interface UsernameService {
 	public Username findByUsername(String username);
 	public Username disableOrEnable(Username username);
 	public int enableUser(String username);
}
