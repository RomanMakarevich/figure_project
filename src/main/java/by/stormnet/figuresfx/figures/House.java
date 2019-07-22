package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class House extends Figure {

    double cut;

    private House(double cx, double cy, double lineWidth, Color color) {
        super(FIGURES_TYPE_LITTER, cx, cy, lineWidth, color);
    }

    public House(double cx, double cy, double lineWidth, Color color, double cut) {
        this(cx, cy, lineWidth, color);
        this.cut = cut< 20 ? 20 : cut;
    }

    public double getCut() {
        return cut;
    }

    public void setCut(double cut) {
        this.cut = cut;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeRect(cx - (cut * 5), cy - (cut * 2), cut * 10, cut * 7);
        gc.strokeRect(cx - (cut * 4), cy, cut * 3, cut * 3);
        gc.strokeLine(cx - (cut * 2.5), cy, cx - (cut * 2.5), cy + (cut * 3));
        gc.strokeLine(cx - (cut * 4), cy + (cut * 1.5), cx - cut, cy + (cut * 1.5));
        gc.strokeRect(cx + cut, cy - cut, cut * 3, cut * 6);
        gc.fillOval(cx + (cut * 1.5), cy + (cut * 2), cut / 2, cut / 2);
        gc.strokePolygon(
                new double[]{
                        cx - (cut * 6),
                        cx,
                        cx + (cut * 6)
                },
                new double[]{
                        cy - (cut * 2),
                        cy - (cut * 7),
                        cy - (cut * 2)
                },
                3);
        gc.strokeOval(cx - cut, cy - (cut * 5), cut * 2, cut * 2);
        gc.strokeLine(cx - cut, cy - (cut * 4), cx + cut, cy - (cut * 4));
        gc.strokeLine(cx, cy - (cut * 3), cx, cy - (cut * 5));
        gc.strokePolygon(
                new double[]{
                        cx - (cut * 4),
                        cx - (cut * 4),
                        cx - (cut * 2),
                        cx - (cut * 2)
                },
                new double[]{
                        cy - (cut * 3.7),
                        cy - (cut * 7),
                        cy - (cut * 7),
                        cy - (cut * 5.4)
                },
                4);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return Double.compare(house.getCut(), getCut()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCut());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("House{");
        sb.append("cut=").append(cut);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
