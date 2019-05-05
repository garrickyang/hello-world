$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Test login",
  "description": "",
  "id": "test-login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "login Baidu",
  "description": "",
  "id": "test-login;login-baidu",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "open site page \u0027https://www.baidu.com/\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "type name \u0027见龙耕田\u0027 and  passowrd \u0027Spring99\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I shoud see my name \u0027见龙耕田\u0027",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.baidu.com/",
      "offset": 16
    }
  ],
  "location": "LoginStepdefs.open_site_page(String)"
});
formatter.result({
  "duration": 438458722,
  "error_message": "org.openqa.selenium.WebDriverException: Cannot find firefox binary in PATH. Make sure firefox is installed. OS appears to be: WIN10\nBuild info: version: \u00272.52.0\u0027, revision: \u00274c2593cfc3689a7fcd7be52549167e5ccc93ad28\u0027, time: \u00272016-02-11 11:22:43\u0027\nSystem info: host: \u0027garrick-THINK\u0027, ip: \u0027192.168.0.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027x86\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_73\u0027\nDriver info: driver.version: BrowserDriver\r\n\tat org.openqa.selenium.firefox.internal.Executable.\u003cinit\u003e(Executable.java:75)\r\n\tat org.openqa.selenium.firefox.FirefoxBinary.\u003cinit\u003e(FirefoxBinary.java:60)\r\n\tat org.openqa.selenium.firefox.FirefoxBinary.\u003cinit\u003e(FirefoxBinary.java:56)\r\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:124)\r\n\tat seleniumtest.BrowserDriver.getCurrentDriver(BrowserDriver.java:17)\r\n\tat seleniumtest.BrowserDriver.loadPage(BrowserDriver.java:46)\r\n\tat seleniumtest.LoginStepdefs.open_site_page(LoginStepdefs.java:18)\r\n\tat ✽.Given open site page \u0027https://www.baidu.com/\u0027(login.feature:4)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "见龙耕田",
      "offset": 11
    },
    {
      "val": "Spring99",
      "offset": 32
    }
  ],
  "location": "LoginStepdefs.type_name_and_passowrd(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "见龙耕田",
      "offset": 21
    }
  ],
  "location": "LoginStepdefs.i_shoud_see_my_name(String)"
});
formatter.result({
  "status": "skipped"
});
});