package Medical_Coding.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "inquiries")
public class Inquiry {
    @Id
    private String id;
    private String name;
    private String phone;
    private String inquiryType;
    private String message;
    private LocalDateTime createdAt;
}
