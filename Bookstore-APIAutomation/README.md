BookStore-API Automation Framework
Goal/Implementation
This project automates REST API testing for a BookStore application using Java, RestAssured, TestNG, Cucumber, and Extent Reports for reporting. 
Tools & TechStack
| Component | Purpose | | -------------- | ------------------------------------------------ | | Java | Programming language | | RestAssured | REST API testing library | | TestNG | Test framework for execution and assertions | | Cucumber | BDD framework for defining feature files | | Extent Reports | Advanced test reporting and logging | | Maven | Dependency and build management | | Jenkins | Continuous Integration and Deployment (optional) | | Git | Version control |
Features
•	Complete CRUD API test coverage (Create, Read, Update, Delete)
•	Positive and negative test scenarios
•	Request chaining to use output from one API call as input to another
•	Environment-specific configuration via config.properties
•	Integration with Cucumber for behavior-driven development (BDD) style tests
•	TestNG as the test execution engine for flexible test management
•	Advanced, detailed HTML reports powered by Extent Reports
•	Listener-based logging for real-time test feedback
•	CI/CD pipeline setup via Jenkins (or GitHub Actions, easily extendable)
 
 
Setup & Configuration
1.	Prerequisites:
2.	Java 20+ installed and configured
3.	Maven installed (mvn command available)
4.	IDE of choice (IntelliJ, Eclipse, VSCode)
5.	Jenkins (optional) for CI/CD
6.	Clone the Repository: 
`bash git clone https://your-repo-url.git cd your-project `
7.	Configure API Endpoint: Update the config.properties file: 
`properties base.url=https://api.yourdomain.com environment=dev `
8.	Install Dependencies: 
`bash mvn clean install `
 
How to Run Tests
•	Run all tests via Maven: 
`bash mvn test `
•	Run tests using TestNG suite: 
`bash mvn test -DsuiteXmlFile=testng.xml `
•	Run tests via IDE: Execute TestRunner.java as a TestNG test or run feature files via Cucumber plugin.
 
Reporting
•	Extent Reports: After test execution, detailed HTML reports will be generated in the extent-reports folder. Open extent-reports/report.html in your browser to view a rich, interactive report showing:
•	Passed/Failed/Skipped tests
•	Detailed logs and screenshots (if any)
•	Test execution time and environment info
•	Cucumber Reports: Cucumber also produces an HTML report in target/cucumber-html-report.html for BDD test overview.
 

Challenges & Solutions
| Challenge | Solution | | ------------------------------------------- | --------------------------------------------------------------------------- | | Handling dynamic data between API calls | Implemented request chaining via shared variables (e.g., userId) in tests | | Reporting detailed logs with screenshots | Integrated Extent Reports with TestNG listener for rich HTML reports | | Managing parallel execution and flaky tests | Configured TestNG with proper dependencies and isolation in tests | | CI/CD integration with Jenkins pipelines | Created Jenkinsfile with stages for build, test, and report publication |
 
CI/CD Integration
•	The Jenkinsfile includes:
•	Code checkout from Git
•	Maven build and test execution
•	Extent report publishing as HTML artifact
•	You can configure GitHub Actions or other CI tools similarly to run tests on each push or PR.
 
Future Improvements
•	Add data-driven testing with external CSV file
•	Integrate API contract testing with tools like Pact
•	Implement parallel test execution and distributed testing
 
