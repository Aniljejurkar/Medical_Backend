package Medical_Coding.service.Impl;

import Medical_Coding.model.Lead;
import Medical_Coding.model.LeadRequestDTO;
import Medical_Coding.repository.LeadRepository;
import Medical_Coding.service.EmailService;
import Medical_Coding.service.LeadService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class LeadServiceImpl implements LeadService {
    private final LeadRepository repository;
    private final EmailService emailService;

public LeadServiceImpl(LeadRepository repository,EmailService emailService)
{
    this.repository=repository;
    this.emailService=emailService;
}

    @Override
    public void saveLeadAndNotifyAdmin(LeadRequestDTO dto) {

        // 1. Save to DB
        Lead lead = new Lead();
        lead.setEmail(dto.getEmail());
        lead.setPhone(dto.getPhone());
        lead.setCreatedAt(LocalDateTime.now());

        repository.save(lead);

        // 2. Send mail to admin
        emailService.sendLeadNotification(lead);
    }
}
