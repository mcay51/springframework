package tr.com.mcay.springannotations.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Service: Basit bir servis sınıfı.
 */
@Service
public class AppInfoService {

        /**
         * @Value: application.properties dosyasından değerleri çeker.
         */
        @Value("${app.name}")
        private String appName;

        @Value("${app.version}")
        private String appVersion;

        public String getAppInfo() {
            return "Uygulama Adı: " + appName + ", Versiyon: " + appVersion;
        }

}


