 Project Structure
PROJECT_MINI/
├─ pom.xml
├─ testng.xml
├─ Jenkinsfile
├─ config/
│  └─ config.properties
│
├─ src/
│  ├─ main/java/com/project/
│  │   ├─ driver/
│  │   │    └─ BrowserFactory.java
│  │   │
│  │   ├─ pages/
│  │   │   ├─ LoginPage.java
│  │   │   ├─ HomePage.java
│  │   │   ├─ ProductPage.java
│  │   │   ├─ CartPage.java
│  │   │   ├─ CheckoutPage.java
│  │   │   └─ ProfilePage.java
│  │   │
│  │   └─ utils/
│  │        ├─ ConfigReader.java
│  │        ├─ Waits.java
│  │        ├─ ScreenshotUtil.java
│  │        ├─ LoggerUtil.java
│  │        ├─ TestListener.java
│  │        └─ TestUtils.java
│  │
│  └─ test/java/com/project/tests/
│      ├─ BaseTest.java
│      ├─ LoginTests.java
│      ├─ RegistrationTests.java
│      ├─ ProductTests.java
│      ├─ CartTests.java
│      ├─ CheckoutTests.java
│      └─ ProfileTests.java
│
└─ resources/
   └─ log4j2.xml

🧰 Tech Stack
Component	Technology
Language	Java 11+
Test Framework	TestNG
Automation	Selenium WebDriver
Build Tool	Maven
Reporting	Extent Reports / TestNG HTML
Logging	Log4j2
CI/CD	Jenkins Pipeline
Pattern	Page Object Model (POM)
⚙ Configuration

Location:
config/config.properties

Example:

browser=chrome
baseUrl=https://demo.nopcommerce.com/
implicitWait=10
timeout=20
takeScreenshots=true

🚀 How to Run Tests
✔ Run all tests
mvn clean test

✔ Run with specific browser
mvn clean test -Dbrowser=edge

✔ Run using TestNG suite
Right-click → Run testng.xml

✔ Run a specific test class

Example:

LoginTests → Right Click → Run

▶ Framework Modules Overview
1️⃣ Driver Layer
BrowserFactory.java

Initializes Chrome, Firefox, Edge

Reads browser from CLI or config

Applies waits + window maximize

2️⃣ Page Object Layer
LoginPage.java

Login

Logout

Invalid login handling

HomePage.java

Search

Navigate to cart, profile, categories

ProductPage.java

Add to cart

Product validations

CartPage.java

Update quantity

Remove item

Check cart status

Accept T&C

CheckoutPage.java

Full checkout

Shipping & billing steps

Empty cart validation

ProfilePage.java

Edit profile

View profile

3️⃣ Utilities Layer
ConfigReader.java

Loads properties file.

Waits.java

Explicit waits helper.

ScreenshotUtil.java

Captures screenshots on failure.

LoggerUtil.java

Centralized logging using Log4j2.

TestListener.java

Logs test lifecycle

Captures screenshots

Creates Extent Report

TestUtils.java

Helpers used across tests.

🧪 Test Layer
BaseTest.java

Loads config

Starts WebDriver

Initializes page classes

Quits driver

Test Classes
Class	Description
LoginTests	Positive + negative login scenarios
RegistrationTests	Placeholder for signup tests
ProductTests	Search & add to cart
CartTests	Update, remove, empty cart
CheckoutTests	Full checkout flows
ProfileTests	Edit + view profile
📊 Reports

After test execution, reports are generated at:

target/surefire-reports/
target/extent-reports/

📸 Screenshots

Automatically captured on failure:

target/screenshots/


Managed by:

ScreenshotUtil

TestListener

🤖 Jenkins CI/CD Pipeline
1️⃣ Create Pipeline Job

Enter repository URL → Save.

2️⃣ Jenkinsfile Already Included

Framework supports:

Browser parameter

HTML publishing

Screenshot archiving

Example build step:

clean test -Dbrowser=${BROWSER}

3️⃣ Post Build Actions

Enable:

Publish HTML Report

Archive screenshots

Email notifications

🧪 Test Scenarios Covered
🔐 Authentication

Valid login

Invalid login

Logout

🔍 Product Search

Search existing product

Search invalid product

Open product from search

🛍 Product

Add product to cart

Validate product details

🛒 Cart

Update quantity

Remove item

Validate empty cart

💳 Checkout

Complete checkout

Checkout with missing fields

Checkout with empty cart

👤 Profile

Edit user profile

Verify profile data
