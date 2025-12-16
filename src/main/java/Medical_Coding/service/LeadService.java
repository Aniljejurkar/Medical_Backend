package Medical_Coding.service;

import Medical_Coding.model.LeadRequestDTO;

public interface LeadService {
    void saveLeadAndNotifyAdmin(LeadRequestDTO dto);
}
