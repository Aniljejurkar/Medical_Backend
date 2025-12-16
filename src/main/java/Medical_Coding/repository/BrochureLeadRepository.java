package Medical_Coding.repository;

import Medical_Coding.model.BrochureLead;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrochureLeadRepository extends MongoRepository<BrochureLead, String> {
}
