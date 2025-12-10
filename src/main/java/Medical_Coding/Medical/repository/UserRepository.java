package Medical_Coding.Medical.repository;

import Medical_Coding.Medical.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Optional: custom query methods
}
