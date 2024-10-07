package tr.com.mcay.springannotations.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/**
 * @Service: Servis katmanı için kullanılır.
 */
@Service
public class ScheduledTaskService {
    /**
     * @Scheduled: Bu metod her 5 saniyede bir çalışacak şekilde ayarlanmıştır.
     */
    @Scheduled(fixedRate = 5000)
    public void performTask() {
        System.out.println("Zamanlanmış görev çalışıyor: " + System.currentTimeMillis());
    }
    /**
     * @Scheduled: Bu metod her gün saat 10:00'da çalışacak şekilde ayarlanmıştır.
     */
    @Scheduled(cron = "0 0 21 * * ?")
    public void performDailyTask() {
        System.out.println("Günlük zamanlanmış görev çalışıyor");
    }
}
