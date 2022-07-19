package spring.springboot.ProfilesConfiguration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("profile2")
public class Profile2 implements ProfileInterface {
    private String profile = "profile2";

    @Override
    public String myFunction() {
        return this.profile;
    }
}
