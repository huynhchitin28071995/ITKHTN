package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

	UserRepository repository = new UserRepository();
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		model.User obj = repository.logon(username);
		//System.out.println(obj.getUsername());
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : obj.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new User(obj.getUsername(), obj.getPassword(), true, true, true, true, authorities);
	}
	
}
