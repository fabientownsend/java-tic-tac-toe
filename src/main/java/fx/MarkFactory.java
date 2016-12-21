package fx;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import tictactoe.Marks;

public class MarkFactory extends StackPane {
    private final int WIDTH_SHAPE = 5;
    private final int tileSize;

    public MarkFactory(int x, int y, int tileSize) {
        this.setWidth(tileSize);
        this.setHeight(tileSize);
        this.tileSize = tileSize;
        relocate(x * tileSize, y * tileSize);
    }

    public  void make(Marks mark) {
        if (mark == Marks.CROSS) {
            getChildren().addAll(createBean(45), createBean(-45));
        } else {
            getChildren().add(createCircleStroke());
        }
    }

    private Rectangle createBean(int angle) {
        Rectangle beam = new Rectangle();
        beam.setHeight(WIDTH_SHAPE);
        beam.setWidth(tileSize);
        beam.setFill(Color.BLACK);
        beam.setRotate(angle);
        beam.setTranslateY(tileSize / 2);
        return beam;
    }

    private Circle createCircleStroke() {
        Circle circle = new Circle();
        circle.setRadius(tileSize / 4);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(WIDTH_SHAPE);
        circle.setTranslateX(tileSize /4);
        circle.setTranslateY(tileSize /4);
        return circle;
    }
}
