package Medical_Coding.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value; // <-- Import this
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    // 1. Inject the URI from application.properties
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean
    public MongoClient mongoClient() {
        // This is usually not needed unless you are on a very old JDK/OS
        // System.setProperty("jdk.tls.client.protocols", "TLSv1.2,TLSv1.3");

        // 2. Use the injected variable instead of the placeholder
        ConnectionString connectionString =
                new ConnectionString(mongoUri);

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .retryWrites(true)
                .build();

        return MongoClients.create(settings);
    }


}