package tr.com.mcay.springannotations.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnProductionCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Eğer ortam değişkeni 'production' ise true döner
        return "production".equals(System.getProperty("stage_env"));
    }
}
