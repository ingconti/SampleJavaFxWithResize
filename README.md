# SampleJavaFxWithResize

sample usage of JAVAFX +  resize of windows, but MAINLY Jar creation.

this project is the companion app for slides for JAVAFX on ing sw. POLIMI

Use JDK 15 for macOS if You see glitches on video using fonts.

-- how to build a JAR

1) due to a known problem, (http://mail.openjdk.java.net/pipermail/openjfx-dev/2018-June/021977.html)
we have to use an helper class.
   
2) add a file Launcher.Java, whose code is:

public class Launcher {

    public static void main(String[] args) {
        App.main(args);
    }
}

3) change refs in maven from you actual name (if starting from javafx siter sample.. ) to this clsass:

from:
    <mainClass>org.example.App</mainClass>
to:
    <mainClass>org.example.Launcher</mainClass>

4) to run in intelliJ, change main class in "Edit Configuration" to "Launcher"


5) ... run "mvn clean!" :)

