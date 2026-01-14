package Medical_Coding.repository;

import Medical_Coding.model.Inquiry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface InquiryRepository extends MongoRepository<Inquiry, String> {


}
