package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    private double lengthOfTheEdge;

    private Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURES_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double lengthOfTheEdge) {
        this(cx, cy, lineWidth, color);
        this.lengthOfTheEdge = lengthOfTheEdge;
    }

    public double getLengthOfTheEdge() {
        return lengthOfTheEdge;
    }

    public void setLengthOfTheEdge(double lengthOfTheEdge) {
        this.lengthOfTheEdge = lengthOfTheEdge;
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(
                new double[]{
                        cx,
                        cx + lengthOfTheEdge / 2,
                        cx - lengthOfTheEdge / 2
                },
                new double[]{
                        cy - lengthOfTheEdge / 2,
                        cy + lengthOfTheEdge / 2,
                        cy + lengthOfTheEdge / 2
                },
                3);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("lengthOfTheEdge=").append(lengthOfTheEdge);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.getLengthOfTheEdge(), getLengthOfTheEdge()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLengthOfTheEdge());
    }
}
