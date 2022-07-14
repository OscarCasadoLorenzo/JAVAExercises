package spring.springboot.DependencyInjection;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    List<City> getCities();
    City addCity(City city);

}
