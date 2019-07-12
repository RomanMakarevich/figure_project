package by.stormnet.figuresfx.controller;

import by.stormnet.figuresfx.drawutils.Drawer;
import by.stormnet.figuresfx.figureException.UnknownFigureException;
import by.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);

    private Random random;
    private ArrayList<Figure> figures;
    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("MainScreenViewController started!");
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;

        switch (random.nextInt(6)) {
            case Figure.FIGURES_TYPE_CITCLE:
                figure = new Circle(x, y, random.nextInt(10), Color.GREEN, random.nextInt(50));
                logger.trace("Circule created");
                break;
            case Figure.FIGURES_TYPE_RECTANGLE:
                figure = new Ractangle(x, y, random.nextInt(10), Color.DARKBLUE, random.nextInt(50));
                logger.trace("Rectangle created");
                break;
            case Figure.FIGURES_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(10), Color.YELLOW, random.nextInt(50));
                logger.trace("Triangle created");
                break;
            case Figure.FIGURES_TYPE_HEART:
                figure = new Heart(x, y, random.nextInt(10), Color.RED, random.nextInt(50));
                logger.trace("Heart created");
                break;
            case Figure.FIGURES_TYPE_CUBE:
                figure = new Cube(x, y, random.nextInt(10), Color.PLUM, random.nextInt(50));
                logger.trace("Cube created");
                break;
            case Figure.FIGURES_TYPE_LITTER:
                figure = new House(x, y, random.nextInt(3), Color.BLACK, random.nextInt(30));
                break;
            default:
                try {
                    throw new UnknownFigureException("Unknown figure");
                } catch (UnknownFigureException e) {
                    logger.error(e.getMessage());
                }
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
