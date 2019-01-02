package com.trilogy.project.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.trilogy.project.model.Role;
import com.trilogy.project.model.User;
import com.trilogy.project.repository.RoleRepository;
import com.trilogy.project.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserDetailsService,UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		if(user.getPassword()==null && user.getId()!=0) {
			user.setPassword(findById(user.getId()).getPassword());
		}
		else {		
			if(user.getPassword()==null)
				user.setPassword(bCryptPasswordEncoder.encode("password"));
			else
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}		
        user.setActive(1);
        System.out.println("Updating the script with new role ");
        Role userRole = roleRepository.findByRole(user.getRoles()
        		.stream()
        		.findFirst()
        		.orElse(roleRepository.findByRole("EMPLOYEE")).getRole());
        
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
      /**  if(user.getRoles() == null || user.getRoles().size()==0) {
        	Role userRole = roleRepository.findByRole("EMPLOYEE");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        }else
        {        
        	
        	Role userRole = roleRepository.findByRole(user.getRoles().stream().findFirst().orElse(roleRepository.findByRole("EMPLOYEE")).getRole());
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        }**/
		userRepository.save(user);
		return user;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User deleteUserById(Long id) {
		User user = findById(id);
		userRepository.deleteById(id);
		return user;
	}
	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority());
	}

}