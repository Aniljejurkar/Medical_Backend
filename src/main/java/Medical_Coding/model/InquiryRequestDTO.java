package Medical_Coding.model;

import lombok.Data;

@Data
public class InquiryRequestDTO {
    private String name;
    private String phone;
    private String inquiryType;
    private String message;
}
