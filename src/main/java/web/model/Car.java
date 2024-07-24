package web.model;

public class Car {
    private int id;
    private String make;
    private String model;

    // Конструкторы
    public Car(int id, String make, String model) {
        this.id = id;
        this.make = make;
        this.model = model;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
