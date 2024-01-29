package teacher_sandbox;

public class PenUsage {
    public static void main(String[] args) {
        Pen pen1 = new Pen(Pen.TypeOfDrawing.BALLPOINT, "blue", true);
        Pen pen2 = new Pen(Pen.TypeOfDrawing.BALLPOINT, "blue", true);

        System.out.println("pen1 == pen2 = " + (pen1 == pen2));
        System.out.println("pen1.equals(pen2) = " + pen1.equals(pen2));
        System.out.println("pen1.hashCode() = " + pen1.hashCode());
        System.out.println("pen2.hashCode() = " + pen2.hashCode());

        pen1.setInkColor("black");
        System.out.println("pen1.hashCode() = " + pen1.hashCode());
        System.out.println("pen2.hashCode() = " + pen2.hashCode());

        pen1.setInkColor("blue");
        System.out.println("pen1.hashCode() = " + pen1.hashCode());
        System.out.println("pen2.hashCode() = " + pen2.hashCode());

        pen2.setCanDraw(false);
        pen1.setInkColor("blue");
        System.out.println("pen1.hashCode() = " + pen1.hashCode());
        System.out.println("pen2.hashCode() = " + pen2.hashCode());

        pen1.draw();
        pen2.draw();

    }
}
