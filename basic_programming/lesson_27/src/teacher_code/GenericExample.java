package teacher_code;

import java.util.Scanner;

public class GenericExample <L, N, M> {
    private L l;
    private N n;
    private M m;
    private Object tempMValue;

    public GenericExample(L l, N n, M m) {
        this.l = l;
        this.n = n;
        this.m = m;
    }

    public void showInfo() {
        System.out.println("\"тип данны L \" = " + l.getClass().getSimpleName());
        System.out.println("\"тип данны N \" = " + n.getClass().getSimpleName());
        System.out.println("\"тип данны M \" = " + m.getClass().getSimpleName());
    }

    public void changeLType(L l) {
        this.l = l;
        this.m = null;
    }

    public static void main(String[] args) {
        var x = 12;
        x = 12342;

        GenericExample<String, Integer, Scanner> genericExample =
                new GenericExample<>("hello", 123, new Scanner(System.in));

        genericExample.showInfo();


    }
}
