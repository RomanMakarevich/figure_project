package by.stormnet.figuresfx.controller;

import by.stormnet.figuresfx.drawutils.Drawer;
import by.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;


import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {

    private Random random;
    private ArrayList<Figure> figures;
    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("MainScreenViewController!");
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
//        if (figures.isEmpty()) {
//            figures.add(0, figure);
//            return;
//        }
        figures.add(figure);
//        Figure[] tmp = new Figure[figures.length + 1];
//        int index = 0;
//        for (; index < figures.length; index++) {
//            tmp[index] = figures[index];
//        }
//        tmp[index] = figure;
//        figures = tmp;
    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;

        switch (random.nextInt(5)) {
            case Figure.FIGURES_TYPE_CITCLE:
                figure = new Circle(x, y, random.nextInt(10), Color.GREEN, random.nextInt(50));
                break;
            case Figure.FIGURES_TYPE_RECTANGLE:
                figure = new Ractangle(x, y, random.nextInt(10), Color.BEIGE, random.nextInt(50));
                break;
            case Figure.FIGURES_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(10), Color.YELLOW, random.nextInt(50));
                break;
            case Figure.FIGURES_TYPE_HEART:
                figure = new Heart(x, y, random.nextInt(10), Color.RED, random.nextInt(50));

            case Figure.FIGURES_TYPE_CUBE:
                figure = new Cube(x, y, random.nextInt(10), Color.PLUM, random.nextInt(50));
            default:
                System.out.println("Unknown");
        }
        return figure;
    }

    private void repaind() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    public void onMouseClicked(MouseEvent mouseEvent) {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaind();
    }
}
