package com.ewertonrodrigues.workshopmongo.repository;

import com.ewertonrodrigues.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
