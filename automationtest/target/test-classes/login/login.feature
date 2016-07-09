Feature: Test login 

Scenario: login Baidu
Given open site page 'https://www.baidu.com/'
When  type name '见龙耕田' and  passowrd 'Spring99'
Then I shoud see my name '见龙耕田'