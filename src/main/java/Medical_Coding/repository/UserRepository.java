package Medical_Coding.repository;

import Medical_Coding.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // Used for LOGIN
    Optional<User> findByEmail(String email);
}
