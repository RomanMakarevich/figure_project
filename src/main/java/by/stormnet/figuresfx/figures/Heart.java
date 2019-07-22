package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Objects;

public class Heart extends Figure {
    private double cut;

    private Heart(double cx, double cy, double lineWidth, Color color) {
        super(FIGURES_TYPE_HEART, cx, cy, lineWidth, color);
    }

    public Heart(double cx, double cy, double lineWidth, Color color, double cut) {
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
        gc.strokeArc(cx - (cut * 3 + (cut / 3)), cy - (cut * 2 + (cut / 4)), cut * 3, cut * 3, 51, 167, ArcType.OPEN);
        gc.strokeArc(cx + (cut / 3.5), cy - (cut * 2 + (cut / 5)), cut * 3, cut * 3, -35, 161, ArcType.OPEN);
        gc.strokeLine(cx, cy - cut, cx - (cut - (cut / 8)), cy - ((cut * 2) - (cut / 10)));
        gc.strokeLine(cx, cy - cut, cx + (cut - (cut / 8)), cy - ((cut * 2) - (cut / 10)));
        gc.strokeLine(cx, cy + cut * 3, cx - ((cut * 3)), cy + (cut / 5.5));
        gc.strokeLine(cx, cy + cut * 3, cx + ((cut * 3)), cy + (cut / 5.5));

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Heart{");
        sb.append("cut=").append(cut);
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
        if (!(o instanceof Heart)) return false;
        Heart heart = (Heart) o;
        return Double.compare(heart.getCut(), getCut()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCut());
    }
}
