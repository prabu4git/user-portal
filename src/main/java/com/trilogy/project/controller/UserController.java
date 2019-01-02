package com.trilogy.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.trilogy.project.model.User;
import com.trilogy.project.service.UserService;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user){    	
        return userService.saveUser(user);
    }

    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") long id){
        return userService.findById(id);
    }
    /**
    @GetMapping(path = {"/{email}"})
    public User findByEmail(@PathVariable("email") String email){
    	System.out.println("@@@@@@@@@@@@@"+userService.findUserByEmail(email).getFirstName());
        return userService.findUserByEmail(email);
    }
 **/

    @PutMapping(path = {"/{id}"})
    public User update(@PathVariable("id") long id, @RequestBody User user){    
        user.setId(id);
     //   if(user.getPassword()==null)
      //  	user.setPassword(userService.findById(id).getPassword());
        return userService.saveUser(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") long id) {
    	System.out.println("Before Deleting =>>>>> "+id);
        return userService.deleteUserById(id);
    }
    
    @GetMapping
    public List<User> findAll(){
        return userService.findAllUsers();
    }

   /* @RequestMapping(value="/userList", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers(){
		List<User> users = userService.findAll();		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+users.size());
		if(users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	} */
}
