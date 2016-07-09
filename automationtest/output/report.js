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
  "duration": 15177714279,
  "status": "passed"
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
  "duration": 4791541338,
  "status": "passed"
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
  "duration": 10235850759,
  "status": "passed"
});
});