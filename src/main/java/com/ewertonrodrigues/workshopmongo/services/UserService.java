package com.ewertonrodrigues.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewertonrodrigues.workshopmongo.domain.User;
import com.ewertonrodrigues.workshopmongo.dto.UserDTO;
import com.ewertonrodrigues.workshopmongo.repository.UserRepository;
import com.ewertonrodrigues.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();	
	}
	
	
	public User findById(String id) {
	    return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
		
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User update(User obj) {
	    Optional<User> optionalUser = repo.findById(obj.getId());
	    User newObj = optionalUser.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	    updateData(newObj, obj); 
	    return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}


	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}

