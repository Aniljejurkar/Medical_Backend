package Medical_Coding.service.Impl;

import Medical_Coding.model.BrochureLead;
import Medical_Coding.repository.BrochureLeadRepository;
import Medical_Coding.service.BrochureService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class BrochureServiceImpl implements BrochureService {

    private final BrochureLeadRepository repository;

    public BrochureServiceImpl(BrochureLeadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Resource saveLeadAndGetBrochure(String email, String phone) {

        BrochureLead lead = new BrochureLead(email, phone);
        repository.save(lead);

        // brochure.pdf should be inside src/main/resources/brochure/
        return new ClassPathResource("brochure/brochure.pdf");
    }
}
