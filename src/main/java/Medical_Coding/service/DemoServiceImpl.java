package Medical_Coding.service;

import Medical_Coding.model.DemoForm;
import Medical_Coding.repository.DemoRepository;
import Medical_Coding.service.Impl.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service

public class DemoServiceImpl  implements DemoService {

    private final DemoRepository demoRepository;

    public   DemoServiceImpl(DemoRepository demoRepository)
    {
       this.demoRepository=demoRepository;
    }

    @Override
    public DemoForm saveForm(DemoForm form) {
        return demoRepository.save(form);
    }
}
