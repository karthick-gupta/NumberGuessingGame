# NumberGuessingGame

This is a repository created for sharing the NumberGuessingGame

Tools Used:

  1. Maven 3.3.9
  2. Eclipse 4.5.2
  3. JDK 1.8

Installation Steps:

  1. Download the project to your local.
  2. Import the project into eclipse.
  3. Right click on pom.xml --> run configuration --> maven configuration
  4. Click browse workspace and choose the base directory as the project
  5. Enter 'package' in goals
  6. Click RUN
  7. You should see BUILD SUCCESS message in the console.

Locations:

  1. Jar file will be located in the below folder path
      /NumberGuessingGame/target/
  2. JUnit Test reports will be located in the below folder path
      /NumberGuessingGame/target/surefire-reports/

Sample JUnit Test Results:

  Running org.example.AppTest
  Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.076 sec

  Results :
  Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

Sample Game Results:

    Let's start the game, guess any number and type 'ready' once you are ready.
    sadf
    You can only enter 'Ready' or 'Quit'!!!
    ready
    Is the Nunmber in your mind : 50 (You Can Say Higher/Lower/Yes)
    no
    You can only enter 'Higher' or 'Lower' or 'Yes'!!!
    Is the Nunmber in your mind : 50 (You Can Say Higher/Lower/Yes)
    higher
    Is the Nunmber in your mind : 75 (You Can Say Higher/Lower/Yes)
    higher
    Is the Nunmber in your mind : 87 (You Can Say Higher/Lower/Yes)
    lower
    Is the Nunmber in your mind : 81 (You Can Say Higher/Lower/Yes)
    lower
    Is the Nunmber in your mind : 78 (You Can Say Higher/Lower/Yes)
    higher
    Is the Nunmber in your mind : 79 (You Can Say Higher/Lower/Yes)
    higher
    Is the Nunmber in your mind : 80 (You Can Say Higher/Lower/Yes)
    yes
    Hurray I did it... Do you want to play again...!!!
    quit
    Sorry :( you are leaving... Please come back again!!!
