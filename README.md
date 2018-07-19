#web tests

Project created with JUnit, webdriver manager, webdriver, htmlelements and assertJ

To run execute ./gradlew clean test -DdriverType=DRIVER_NAME -DhubAddress=HUB_ADDRESS
Where DRIVER_TYPE in (chrome, firefox) and HUB_ADDRESS like http://HOST:PORT/wd/hub

In case if you want to launch tests on other app, then use gradle clean test -DapplicationAddress=APP_ADDRESS

Further improvement options :
1. Reports with Allure
2. Screenshots
3. Smarter way to wait page ready status (through WebDriver listener)
