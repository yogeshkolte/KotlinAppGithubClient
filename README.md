# KotlinAppGithubClient
1)Install the latest Java Development Kit (JDK).
  1)For instructions follow the links below.
    https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-0071963E-D247-4D15-BF49-AD19C7260740
    https://www.oracle.com/java/technologies/javase-jdk11-downloads.html

  2)Verify Installation : java -version

2)Install Gradle. This project uses Gradle as a build system.
  1)Installation instructions: https://gradle.org/install
  2)Verify Installation: gradle -version

3)Install Kotlin.
  1)Installation Instructions: https://kotlinlang.org/docs/tutorials/command-line.html
  2)Verify Install: kotlinc -version

4)If you would like to open the source code in IDE you could use Visual Studio Code or IntelliJ IDEA CE.

5)Get the source code from https://github.com/yogeshkolte/KotlinAppGithubClient

6)Build source code by running the following command in the root directory of the project
  1) ./gradlew shadowJar 
  2) Run the app using following command java -jar app/build/libs/app-all.jar <userName> <token>

7) I have included a runnable JAR file in the repository. You can run the app using following command
  1) java -jar app-all.jar <userName> <token>
