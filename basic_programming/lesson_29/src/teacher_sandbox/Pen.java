package teacher_sandbox;

// класс, характеризующий ручку, для практики методов equals и hashCode
public class Pen {
    // тип ручки - вложенный энам, может быть шариковой или перьевой
    private TypeOfDrawing typeOfDrawing;
    // цвет чернил ручки
    private String inkColor;
    // характеристика ручки - может писать или нет
    private boolean canDraw;

    public Pen(TypeOfDrawing typeOfDrawing, String inkColor, boolean canDraw) {
        this.typeOfDrawing = typeOfDrawing;
        this.inkColor = inkColor;
        this.canDraw = canDraw;
    }

    void draw(){
        if (canDraw) {
            System.out.println(this.toString() + " drawing");
        } else {
            throw new RuntimeException("Pen cant draw!");
        }
    }

    public TypeOfDrawing getTypeOfDrawing() {
        return typeOfDrawing;
    }

    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    public boolean isCanDraw() {
        return canDraw;
    }

    public void setCanDraw(boolean canDraw) {
        this.canDraw = canDraw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pen) || o == null) {
            return false;
        }

        Pen pen = (Pen) o;

        if (this.canDraw != pen.canDraw) return false;
        if (this.typeOfDrawing != pen.typeOfDrawing) return false;
        return this.inkColor.equals(pen.inkColor);
    }

    @Override
    public int hashCode() {
        int result = 0;
        int colorHashCode = inkColor.hashCode();
        int typeHashCode = typeOfDrawing.hashCode();
        int canDrawHashCode = Boolean.valueOf(canDraw).hashCode();

        result = 31 * colorHashCode + 31 * typeHashCode + 31 * canDrawHashCode;

        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "typeOfDrawing=" + typeOfDrawing +
                ", inkColor='" + inkColor + '\'' +
                ", canDraw=" + canDraw +
                '}';
    }

    enum TypeOfDrawing {
        BALLPOINT, INK;
    }
}
