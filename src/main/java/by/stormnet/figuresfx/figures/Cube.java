package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cube extends Figure {
    private double cut;

    private Cube(double cx, double cy, double lineWidth, Color color) {
        super(FIGURES_TYPE_CUBE, cx, cy, lineWidth, color);
    }

    public Cube(double cx, double cy, double lineWidth, Color color, double cut) {
        this(cx, cy, lineWidth, color);
        this.cut = cut;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeRect(cx, cy, cut * 2, cut * 2);
        gc.strokeLine(cx, cy, cx - cut, cy - cut);
        gc.strokePolygon(new double[]{
                        cx - cut,
                        cx - cut,
                        cx,
                        cx + cut * 2,
                        cx + cut * 2,
                        cx + cut
                },
                new double[]{
                        cy - cut,
                        cy + cut,
                        cy + cut * 2,
                        cy + cut * 2,
                        cy,
                        cy - cut

                },
                6);
    }
}
