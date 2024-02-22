package task_3;

public class Barge extends Vehicle implements PeopleTransport, CargoTransport {

    private double cargo;
    private int passengers;
    private int bargeWeight;

    protected Barge(int bargeWeight, double speed, double fuelAmount, double fuelPerKm) {
        super(speed, fuelAmount, fuelPerKm);
        this.bargeWeight = 0;
        cargo = 0;
        passengers = 0;

    }

    @Override
    public double calculateCargoConsumptionPerKm() {
        return fuelPerKm * 0.0002 * cargo;
    }

    @Override
    public double calculatePassengersConsumptionPerKm() {
        return passengers * 0.0001 * fuelPerKm;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        System.out.println("Путь баржи займет " + distance / speed + "ч" );
        return distance * (fuelPerKm + calculateCargoConsumptionPerKm()
                + calculatePassengersConsumptionPerKm());
    }

    // геттеры и сеттеры
    @Override
    public int getPassengers() {
        return passengers;
    }

    @Override
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public double getCargo() {
        return cargo;
    }

    @Override
    public void setCargo(double cargo) {
        this.cargo = cargo;
    }
}