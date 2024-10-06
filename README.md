# Selenium_TealiumDemo
Selenium Automation for TealiumDemo Store
# Test Automation Documentation

## Table of Contents
1. [Test Framework Structure](#test-framework-structure)
   - [Framework Design](#framework-design)
   - [Configuration](#configuration)
2. [Test Cases](#test-cases)
   - [1. User Registration and Login](#user-registration-and-login)
   - [2. Product Search and Filter](#product-search-and-filter)
   - [3. Shopping Cart Management](#shopping-cart-management)
   - [4. Checkout Process](#checkout-process)
3. [Setup Instructions](#setup-instructions)

---

## Test Framework Structure

### Framework Design
The test automation framework is built using **Selenium WebDriver** for browser automation and **TestNG** for structuring test cases and managing test execution. The framework is designed to be modular and maintainable, supporting easy addition of new test cases.

**Key Components:**
- **Base Classes**: Provides common functionalities for all tests, such as WebDriver setup and teardown.
- **Page Object Model (POM)**: Each page of the application has a corresponding class, encapsulating its elements and actions.
- **Test Suites**: Organized by features, with separate XML files for execution.
- **Utilities**: Contains helper functions for common operations like reading data from files or generating random data.

### Configuration
The framework is configured with the necessary dependencies, ensuring that it can run independently on any machine. All local dependencies are bundled within the project. The following libraries are included:

- **Selenium Java**: For web automation
- **TestNG**: For test management
- **Java Properties**: For configuration management
- **Extent Reports**: For generating detailed test reports




## Test Cases

### 1. User Registration and Login
- **Objective**: Verify that users can register and log in successfully.
- **Steps**:
  1. Navigate to the registration page.
  2. Fill in the registration form with valid data.
  3. Submit the form and verify the registration success message.
  4. Navigate to the login page.
  5. Enter the registered credentials and submit.
  6. Verify that the user is redirected to the dashboard.

### 2. Product Search and Filter
- **Objective**: Ensure that users can search for products and apply filters.
- **Steps**:
  1. Navigate to the homepage.
  2. Enter a product name in the search bar and submit.
  3. Verify that the search results match the applied filters.

### 3. Shopping Cart Management
- **Objective**: Validate adding, updating, and removing products in the shopping cart.
- **Steps**:
  1. Navigate to a product page.
  2. Add a product to the cart.
  3. Go to the cart page.
  4. Verify that the product is listed.
  5. Remove the product from the cart and verify it is no longer listed.

### 4. Checkout Process
- **Objective**: Test the complete checkout process.
- **Steps**:
  1. Navigate to the shopping cart.
  2. Click on the checkout button.
  3. Fill in shipping and payment information.
  4. Submit the order.
  5. Verify the order confirmation message.

     ## Setup Instructions

### 1. Clone the Repository
Clone the project repository from your version control system (e.g., Git).

### 2. Install Java and Maven
Ensure that you have Java (JDK 8 or higher) and Maven installed on your machine.

### 3. Import the Project
Import the project into your IDE (e.g., IntelliJ IDEA or Eclipse) as a Maven project.

### 4. View Reports
After execution, reports will be generated in the specified output directory (e.g., `target/surefire-reports` for TestNG and `extent-reports` for Extent Reports).

#### Dependencies
Ensure that the following is added to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.x.x</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.x.x</version>
    </dependency>
</dependencies>
