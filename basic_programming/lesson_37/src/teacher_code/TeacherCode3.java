package teacher_code;

import classwork.House;

import java.util.ArrayList;
import java.util.Comparator;

public class TeacherCode3  {
    public static void main(String[] args) {
        House h1 = new House(3, "house 1", 50);
        House h2 = new House(5, "house 2", 20);
        House h3 = new House(1, "house 3", 100);

        ArrayList<House> houses = new ArrayList<>();

        houses.add(h1);
        houses.add(h2);
        houses.add(h3);

        Comparator<House> compareByFloorAsc = (house1, house2) -> {
            int floor1 = house1.getFloor();
            int floor2 = house2.getFloor();
            int result = floor1 - floor2;
            return  result;
        };

        Comparator<House> compareByFloorAscLambda = (house1, house2) -> house1.getFloor() - house2.getFloor();

        houses.sort((house1, house2) -> house1.getFloor() - house2.getFloor());
    }
}
