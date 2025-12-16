package Medical_Coding.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String fullName;
    @Indexed(unique = true)
    private String email;
    private String countryCode;
    private String mobile;
    private String password;

    public User() {
    }

    public User(String id, String fullName, String email, String countryCode, String mobile) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.countryCode = countryCode;
        this.mobile = mobile;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getMobile() {  return password; }
    public void setMobile(String password) { this.password = password; }

    public String getPassword() { return mobile; }
    public void setPassword(String mobile) { this.mobile = mobile; }
}
