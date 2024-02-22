package example01;

public class Main {
    /*
    Разработать простую иерархию транспорта
    У транспорта должно быть свойство "количество топлива" и метод, который позволит посчитать расход топлива
    Добавить интерфейсы PeopleTransport и CargoTransport, которые определят соответствующие методы для дополнительных
    расчетов расхода топлива в зависимости от груза или пассажиров
     */

    public static void main(String[] args) {
        Car car = new Car("Audi", 120, 200, 0.11);
        car.setPassengers(3);

        System.out.println(car.calculateFuelConsumption(600));

        FreightTrain train = new FreightTrain(50, 80, 5000, 0.2);
        train.setCargo(60_000);

        System.out.println(train.calculateFuelConsumption(600));
    }
}
