package spring.springboot.ProfilesConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value={"myconfiguration.properties"})
@Component
public class MyConfiguration {
    @Value("${VALUE1}")
    private Integer value1;

    @Value("${VALUE2}")
    private Integer value2;

    public Integer getValue1() {
        return value1;
    }

    public Integer getValue2() {
        return value2;
    }
}
