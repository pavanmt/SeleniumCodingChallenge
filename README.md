# SeleniumCodingChallenge
Naveen AutomationLabs: Selenium Coding Challenge Series Solution!

# Coding Excersice:
Steps:
1) go to this url -https://www.zoopla.co.uk/
2) Input location London and click submit
3) You will get a list of properties on that page. 
4) Print all the price values in sorted order (descending order) on the console
5) I need to select the 5th property on that list (its changing every minute, so it’s dynamic) 
6) On the next page, there is a logo, name and telephone no of the agent. I need to click on the name link to get into the agent’s page.
7) Once on that page, I need to check that the the properties listed there belong to the same mentioned agent on the page.

Youtube Link: https://www.youtube.com/watch?v=s9KmYPiRYws&feature=youtu.be&fbclid=IwAR3SGMp4zxlamk2-BMQqTJt1MxKod0e2amtbqhYGIqftDRL3mRbAPhr8NOQ

#Framework Walkthrogh
This framework is developed using Java TestNg framework with page factory design pattern. The page bases are defined under src/main and the tests are written under src/tests.

# Test Execution
1. Run tests.xml located under src/test/resources folder as a TestNg Suite.
2. By default browser is set as chrome, can update to firefox by setting the browser property in tests.xml
3. Can also run the tests by running as maven build.
