package Medical_Coding.service;

import Medical_Coding.model.Inquiry;
import Medical_Coding.model.LeadRequestDTO;

import java.util.List;

public interface LeadService {
    void saveLeadAndNotifyAdmin(LeadRequestDTO dto);

    public interface InquiryService {
        List<Inquiry> getAllInquiries();
    }

}
