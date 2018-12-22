package com.techprimers.jpa.springdatajpahibernateexample.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class Resource {

    private UserRepository usersRepository;

    public Resource(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @GetMapping("/")
    public List<Users> all() {


        return usersRepository.findAll();
    }


    @GetMapping("/create")
    public List<Users> users() {
        Users users = new Users();
        users.setId(2);
        users.setName("nitin");
        users.setSalary(340);
        users.setTeamName("Development");

        usersRepository.save(users);

        return usersRepository.findAll();
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/topics") 
    public List<Users> addTopic(@RequestBody Users topic)
    {
    	usersRepository.save(topic);
    	return usersRepository.findAll();
    }
    

    @RequestMapping(method=RequestMethod.POST,value="/update") 
    public List<Users> updateTopic(@RequestBody Users topic)
    {
    	usersRepository.save(topic);
    	return usersRepository.findAll();
    }
    

    @RequestMapping(method=RequestMethod.GET,value="/delete/{id}") 
    public List<Users> deleteTopic(@PathVariable int id)
    {
    	usersRepository.delete(id);
    	return usersRepository.findAll();
    }
    
    @RequestMapping("/topics/{id}")
    public Users userId(@PathVariable int id) {
        Users users = new Users();
         int n = id;
        return usersRepository.findOne(id);
    }
    
}
