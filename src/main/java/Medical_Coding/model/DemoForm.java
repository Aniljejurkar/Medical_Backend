package Medical_Coding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("demo_form")
public class DemoForm {
    @Id
    private String id;
    private String email;
    private String countryCode;
    private String phone;
}
