package Medical_Coding.repository;

import Medical_Coding.model.DemoForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemoRepository extends MongoRepository<DemoForm, String>{
}
