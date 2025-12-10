package Medical_Coding.Medical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users") // MongoDB collection
public class User {

    @Id
    private String id; // MongoDB uses String ID by default

    private String fullName;
    private String email;
    private String countryCode;
    private String mobile;
}
