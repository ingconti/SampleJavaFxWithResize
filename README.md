# SampleJavaFxWithResize

Sample usage of JAVAFX + resize of window/stage, but MAINLY Jar creation.
This project is the companion app for slides for JAVAFX on ing sw. POLIMI
Use JDK 21 for macOS if You see glitches on video using fonts.

-- how to build a JAR

1) due to a known problem, (http://mail.openjdk.java.net/pipermail/openjfx-dev/2018-June/021977.html)
we have to use an helper class.
   
2) add a file Launcher.Java, whose code is:

 public class Launcher {

    public static void main(String[] args) {
        App.main(args);
    }
 }

3) in You project add these maven settings for shade:


            <!-- added SHADE plug in -->

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.0</version>

                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <shadedArtifactAttached>true</shadedArtifactAttached>
                            <shadedClassifierName>project-classifier</shadedClassifierName>
                            <outputFile>shade\${project.artifactId}.jar</outputFile>
                            <transformers>
                                <transformer implementation=
                                                     "org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">

                                    <!-- original:
                                    <mainClass>org.example.App</mainClass>
                                     -->

                                    <mainClass>org.example.Launcher</mainClass>

                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

            <!-- end of added shade plugin -->
   

4) change refs in maven from you actual name (if starting from  sample on javafx site) 
   to this class:

from:
    <mainClass>org.example.App</mainClass>
to:
    <mainClass>org.example.Launcher</mainClass>

(we did leave some comments to remeber it)

5) to run in intelliJ, change main class in "Edit Configuration" to "Launcher"

6) ... run "mvn clean!" :)

7) run "package" from maven.

8) Your working JAR is the one inside "shade" folder, NOT inside "target".

