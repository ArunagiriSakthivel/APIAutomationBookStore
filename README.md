BookStore-API Automation Framework

1.Purpose&Description:

This project automates REST API testing for a BookStore application using Java, RestAssured, TestNG, Cucumber, and Extent Reports for reporting. 


2.Tools & TechStack:

| Component | Purpose | | -------------- | ------------------------------------------------ | | Java | Programming language | | RestAssured | REST API testing library | | TestNG | Test framework for execution and assertions | | Cucumber | BDD framework for defining feature files | | Extent Reports | Advanced test reporting and logging | | Maven | Dependency and build management | | Jenkins | Continuous Integration and Deployment (optional) | | Git | Version control |

3.Features:

    1.	Complete CRUD API test coverage (Create, Read, Update, Delete)
    2.	Positive and negative test scenarios
    3.	Request chaining to use output from one API call as input to another
    4.	Environment-specific configuration via config.properties
    5.	Integration with Cucumber for behavior-driven development (BDD) style tests
    6.	TestNG as the test execution engine for flexible test management
    7.	Advanced, detailed HTML reports powered by Extent Reports
    8.	CI/CD pipeline setup via Jenkins (or GitHub Actions, easily extendable)


4.Configuration:

    1.	Java installed and configured
    2.	Maven installed (mvn command available)
    3.	IDE of choice (IntelliJ, Eclipse, VSCode)
    4.	Jenkins (optional) for CI/CD
    5.	Clone the Repository: 
    `bash git clone https://your-repo-url.git cd your-project `
    6.	Configure API Endpoint: Update the config.properties file: 
    `properties base.url=https://api.yourdomain.com environment=dev `
    7.	Install Dependencies: 
    `bash mvn clean install `


5.How to Execute Tests:

    1. Run all tests via Maven: 
        `bash mvn test `
    2. Run tests using TestNG suite: 
        `bash mvn test -DsuiteXmlFile=testng.xml `
    3.	Run tests via IDE: Execute TestRunner.java as a TestNG test or run feature files via Cucumber plugin.


6.Reporting Structure:

•	Extent Reports: After test execution, detailed HTML reports will be generated in the extent-reports folder. Open extent-reports/report.html in your browser to view a rich, interactive report includes,

    •	Passed/Failed/Skipped tests
    •	Detailed logs and screenshots (if any)
    •	Test execution time and environment info
    •	Cucumber Reports: Cucumber also produces an HTML report in target/cucumber-html-report.html for BDD test overview.


7.CI/CD Pipeline Integration:

    •	The Jenkinsfile includes:
    •	Code checkout from Git
    •	Maven build and test execution
    •	Extent report publishing as HTML artifact
    •	You can configure GitHub Actions or other CI tools similarly to run tests on each push or PR.


8.Future Enhancement:

    •	Add data-driven testing with external CSV file
    •	Implement parallel test execution and distributed testing
