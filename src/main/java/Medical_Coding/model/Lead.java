package Medical_Coding.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "leads")
@Data
public class Lead {
    @Id
    private String id;

    private String email;
    private String phone;
    private LocalDateTime createdAt;
}
