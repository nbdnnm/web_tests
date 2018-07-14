#web tests

Project created with JUnit, webdriver manager, webdriver, htmlelements and assertJ
To run execute ./gradlew clean test
In case if you want to launch tests on other app, then use gradle clean test -DapplicationAddress=APP_ADDRESS

Further improvement options :
1. Cross browser launch
2. Parallel run with Selenoid
3. Reports with Allure
4. Screenshots
5. Smarter way to wait page ready status (through WebDriver listener)
