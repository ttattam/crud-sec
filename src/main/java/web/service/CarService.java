package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car(1, "Toyota", "Corolla"));
        cars.add(new Car(2, "Honda", "Civic"));
        cars.add(new Car(3, "Ford", "Focus"));
        cars.add(new Car(4, "BMW", "3 Series"));
        cars.add(new Car(5, "Audi", "A4"));
    }

    public List<Car> listCars(Integer count) {
        if (count == null || count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}
