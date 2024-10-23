package tr.com.mcay.errorcodesimulation.service.impl;

import org.springframework.stereotype.Service;
import tr.com.mcay.errorcodesimulation.service.RedirectSimulationService;

@Service
public class RedirectSimulationServiceImpl implements RedirectSimulationService {


        @Override
        public String simulate300MultipleChoices() {
            return "Custom 300 Multiple Choices: Birden fazla olası kaynak mevcut.";
        }

        @Override
        public String simulate301MovedPermanently() {
            return "Custom 301 Moved Permanently: Kaynak kalıcı olarak taşındı.";
        }

        @Override
        public String simulate302Found() {
            return "Custom 302 Found: Kaynak geçici olarak başka bir yere taşındı.";
        }

}
