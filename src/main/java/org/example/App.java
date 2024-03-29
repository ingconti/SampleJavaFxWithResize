package org.example;

import com.sun.javafx.runtime.VersionInfo;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class App extends Application {


    public static void main(String[] args) {

        FakeStartParams bootParams = FakeStartParams.fromArgs(args);
        startMyNetwork(bootParams); // fake...
        if (bootParams.asGui) {
            launch();
        }else{
            launchCLI();
        }
    }


    // CLI stuff
    private static void launchCLI(){
        System.out.println("hello CLI");
    }

    // Network stuff (eventually move in another class/package ...

    private static void startMyNetwork(FakeStartParams bootParams){
        System.out.println("network (fake) started!");
    }



    // Java FX stuff

    @Override
    public void start(Stage primaryStage) {

        System.out.println(("JavaFX Version: " + VersionInfo.getVersion()));
        System.out.println(("JavaFX Runtime Version: " + VersionInfo.getRuntimeVersion()));

        primaryStage.setTitle("build JAR and ZOOM Test");

        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));

        //eventually..
        //primaryStage.initStyle(StageStyle.UNDECORATED); // no border at all...

        // if needed..
        //primaryStage.setResizable(false);

        // if needed...
        //primaryStage.setMaximized(true);

        /*
        double ratio = 1; // 1 is full... exactly as if you call built-in method: "primaryStage.setMaximized(true);"
        // if You pass canvas, will be resized, too. Pass nil if You ewant to keep canvas as set above.
        //Boolean keepSquare = true;
        Boolean keepSquare = false;
        maximize(primaryStage, ratio, canvas, keepSquare);
*/
        //eventually..
        addMouseClickListenerTo(canvas); // you you attach to canvas, we will detect ONLY in original rect.

        // but all BEFORE show
        primaryStage.show();

    }


    private void maximize(Stage stage, double ratio,  Canvas alsoCanvas, Boolean keepSquare){
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        double W = primaryScreenBounds.getWidth()/ratio;
        double H = primaryScreenBounds.getHeight()/ratio;

        if (keepSquare) {
            double min = Math.min(W, H);
            W = min;
            H = min;
        }

        stage.setWidth(W);
        stage.setHeight(H);

        if (alsoCanvas != null){
            alsoCanvas.setWidth(W);
            alsoCanvas.setHeight(H);
        }
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


    //private  void addMouseClickListenerTo(Node node){// we can use node, if we want to detect clicks in this node
    private void addMouseClickListenerTo(Node node){

        //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = e -> System.out.println("CLICK! " + e.getX() + " " + e.getY()  );

        //Registering the event filter
        node.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

    }
}