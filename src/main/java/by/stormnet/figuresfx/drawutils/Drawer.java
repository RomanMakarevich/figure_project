package by.stormnet.figuresfx.drawutils;

import by.stormnet.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer<T extends Figure> implements Drawable {
    private List<Figure> figures;

    public Drawer(List<Figure> figures) {
        this.figures = figures;
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (Figure figure : figures) {
            if (figure != null){
                figure.draw(gc);
            }
        }
    }
}
