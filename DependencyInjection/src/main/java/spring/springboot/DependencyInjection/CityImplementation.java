package spring.springboot.DependencyInjection;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityImplementation implements CityService{
    List<City> cityList = new ArrayList<>();

    @Override
    public List<City> getCities() {
        return cityList;
    }

    @Override
    public City addCity(City city) {
        cityList.add(city);
        return city;
    }
}
