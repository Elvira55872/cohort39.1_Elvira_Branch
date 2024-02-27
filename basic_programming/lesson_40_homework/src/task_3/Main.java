package task_3;

public class Main {
    /*
    Разработать простую иерархию транспорта
    У транспорта должно быть свойство "количество топлива" и метод, который позволит посчитать расход топлива
    Добавить интерфейсы PeopleTransport и CargoTransport, которые определят соответствующие методы для дополнительных
    расчетов расхода топлива в зависимости от груза или пассажиров
     */

    /**
     * Задание 3.
     * Взять пример 1 из классной работы и создать новый класс который будет реализовывать оба интерфейса.
     * Продемонстрировать работу класса в main
     */

    public static void main(String[] args) {
        //демонстрация работы класса Barge
        Barge barge = new Barge(1_000_000, 20, 3000, 30);

        barge.setCargo(432);
        barge.setPassengers(516);

        System.out.println("barge Cargo Consumption Per Km: " + barge.calculateCargoConsumptionPerKm());
        System.out.println("barge Passengers Consumption Per Km: " + barge.calculatePassengersConsumptionPerKm());
        System.out.println("barge Fuel Consumption: " + barge.calculateFuelConsumption(500));

        // старый код с урока
        System.out.println();
        Car car = new Car("Audi", 120, 200, 0.11);
        car.setPassengers(3);

        System.out.println(car.calculateFuelConsumption(600));

        FreightTrain train = new FreightTrain(50, 80, 5000, 0.2);
        train.setCargo(60_000);

        System.out.println(train.calculateFuelConsumption(600));
    }
}
