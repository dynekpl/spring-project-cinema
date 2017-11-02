package pl.kodolamacz.spring.dao.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class IdSequenceGenerator implements Generator {

    private AtomicLong count = new AtomicLong(0);

    @Override
    public Long getUniqueId() {
        return count.getAndIncrement();
    }

}
