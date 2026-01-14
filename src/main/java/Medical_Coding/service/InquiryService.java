package Medical_Coding.service;

import Medical_Coding.model.Inquiry;
import Medical_Coding.model.InquiryRequestDTO;

import java.util.List;

public interface InquiryService {
    void saveInquiry(InquiryRequestDTO dto);
    List<Inquiry> getAllInquiries();
}
