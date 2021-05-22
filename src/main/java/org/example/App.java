package org.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Drawing Operations Test");

        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));

        //eventually..
        addMouseClickListenerTo(canvas); // you you attach to canvas, we will detect ONLY in orginal rect.

        //primaryStage.initStyle(StageStyle.UNDECORATED); // no border at all...

        // if needed..
        //primaryStage.setResizable(false);

        // if needed... primaryStage.setMaximized(true);

        double ratio = 1; // 1 is full... exactly as if called buitl in " primaryStage.setMaximized(true);"
        maximize(primaryStage, ratio);

        primaryStage.show();


    }


    private void maximize(Stage stage, double ratio){
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());

        double W = primaryScreenBounds.getWidth()/ratio;
        double H = primaryScreenBounds.getHeight()/ratio;

        stage.setWidth(W);
        stage.setHeight(H);

        //stage.initStyle(StageStyle.UNDECORATED);
       // stage.initStyle(StageStyle.TRANSPARENT);

    }


    public static void main(String[] args) {
        launch();
    }





    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }


    //private  void addMouseClickListenerTo(Node node){// we can use node, if we want to detct clicks in this node
    private  void addMouseClickListenerTo(Node node){

        //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("CLICK! " + e.getX() + " " + e.getY()  );

            }
        };

        //Registering the event filter
        node.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

    }
}