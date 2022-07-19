package spring.springboot.ProfilesConfiguration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("profile1")
public class Profile1 implements ProfileInterface {
    private String profile = "profile1";

    @Override
    public String myFunction() {
        return this.profile;
    }
}
