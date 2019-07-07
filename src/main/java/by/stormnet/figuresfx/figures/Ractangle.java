package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Ractangle extends Figure {
    private double width;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    private Ractangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURES_TYPE_RECTANGLE, cx, cy, lineWidth, color);
    }

    public Ractangle(double cx, double cy, double lineWidth, Color color, double width) {
        this(cx, cy, lineWidth, color);
        this.width = width;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeRect(cx -(width/2), cy - (width/2), width, width);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())return false;
        Ractangle ractangle = (Ractangle) o;
        return Double.compare(ractangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ractangle{");
        sb.append("width=").append(width);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
