# Think Automation project

## Use Maven

Open a command window and run:

    mvn clean verify

## Use Gradle

Open a command window and run:

    gradlew test 

## Running tests by tags

    ./gradlew clean test -Dtags='login'

## Run in firefox

    ./gradlew clean test -Dwebdriver.driver=firefox

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!

