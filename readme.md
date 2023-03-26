

Test automation framework that shows both API and UI automation cases
=========================================================================


1.This project demonstrates POM pattern and how it can be used 
  in Selenium to automate any application. Maven is used as test framework.
  Also, I've implemented the API automation using Rest Assured.

2. For passing test data, and for separating test types UI, API  etc Cucumber is utilized.

3. For reporting cucumber reports are used and reports can be found in folder "target/cucumber-reports/advanced-reports/cucumber-html-reports/feature-overview.html".
   Also, there are different styles of report inside "target" folder

4. For UI failed cases, screenshot can be found in folder "screenShots" folder.

5. Prerequisite : JDK 8 or above, and Maven 3.6 or above

6. To run the all the tests use the following command:

     mvn clean install

   Tests are divided and in ui and api, and tagged with @ui and @api in feature files.

   If a user wants to run only API tests the command for that is :

   mvn test -Dcucumber.filter.tags="@api"

   If a user wants to run only ui tests the command for that is :

   mvn test -Dcucumber.filter.tags="@ui"

7. A user can also directly run "src/test/java/runner/TestRunner.java" file to execute tests

8. Logs can be found as application.log inside the project






