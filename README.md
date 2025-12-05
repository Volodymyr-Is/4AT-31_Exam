# Project README Template

## 1. Architecture

### High-level Architecture (Testing)

The testing architecture is built upon the **PageObject (PO)** pattern for UI tests and the **BusinessObject (BO)** pattern for API tests.

* **WEB UI Tests:**
    * **Layers:** Test Case (TC) $\rightarrow$ Business Object (BO) $\rightarrow$ Page Object (PO) $\rightarrow$ WebElement Wrappers
    * **Drivers:** A **DriverPool** is used to manage multiple drivers (at least Chrome and Firefox).
    * **Data:** **DataProvider** is used for test parameterization.
    * **Reporting:** Allure + detailed logging with screenshots.

* **API Tests:**
    * **Layers:** Test Case (TC) $\rightarrow$ Business Object (BO)
    * **Data:** **DataProvider** and **ORM** (for test data generation and/or validation).
    * **Objects:** Object Wrappers are used for API responses/requests.
    * **Reporting:** Allure + logging with JSON attachments (requests/responses).

* **Performance Tests (JMeter):**
    * **Workload:** The model is defined using a minimum of **3 ThreadGroups**.
    * **Scenarios:** Reproduction of key business flows.
    * **Reporting:** JTL files, metrics analysis.

---

### Components and Interactions

| Component | Role | Interaction |
| :--- | :--- | :--- |
| **Test Cases (TC)** | Defines test scenarios | Calls BO/PO methods |
| **Business Objects (BO)** | Implements business logic | Calls PO (for UI) or API methods (for API) |
| **Page Objects (PO)** | Interacts with WEB UI | Calls WebElement Wrappers |
| **ORM Layer** | Data management/validation | Interacts with DB (if required) |
| **DriverPool** | Browser management | Provides WebDriver instances |

### Technologies Used:

* **Programming Language:** Java / Python / C# (Insert applicable)
* **UI Automation:** Selenium / Cypress / Playwright (Insert applicable)
* **API Automation:** RestAssured / HTTP Client (Insert applicable)
* **Performance:** Apache JMeter
* **Reporting:** Allure Framework
* **Data Management:** ORM (e.g., Hibernate, SQLAlchemy)

### Data Flow (UI Scenario Example)

Test Case $\rightarrow$ DataProvider (TestData) $\rightarrow$ Business Object (BO) $\rightarrow$ Page Object (PO) $\rightarrow$ DriverPool (WebDriver) $\rightarrow$ Savora SM (DEV/PROD)

### Environments: DEV and PROD

* **DEV (Development/Staging):** Used for initial testing and integration.
* **PROD (Production):** Used for Smoke/Regression testing before releases or monitoring.

---

## 2. Target Description

### Product/module name: Savora SM

### Key functionality:

User content management: creating, deleting, and updating posts and user profiles, social interaction (likes, saves).

### Business value:

Ensuring the stable and reliable operation of key social interaction and content management features, which is critical for user engagement and retention.

### Primary testing goals:

1.  Validation of **E2E (End-to-End)** **WEB UI** functionality for core user scenarios.
2.  Validation of **E2E** and business logic for **API** data operations.
3.  Assessment of system **performance** under expected and peak load.

### Constraints or assumptions:

* It is assumed that test accounts and necessary pre-configurations are available.
* The test environment (DEV/Staging) must be functionally identical to PROD.
* **ORM** is used for reading and/or generating unique test data.

---

## 3. Test Case (TC) Description

| ID | Description | Testing Type |
| :--- | :--- | :--- |
| TC-UI-1 | **validate post created** | WEB UI E2E |
| TC-UI-2 | **validate post liked and saved** | WEB UI E2E |
| TC-UI-3 | **validate post deleted** | WEB UI E2E |
| TC-API-1 | **validate post created** | API E2E |
| TC-API-2 | **validate post deleted** | API E2E |
| TC-API-3 | **validate bio updated** | API E2E |
| TC-Perf-1 | **validate post created** | JMeter (Load) |
| TC-Perf-2 | **validate post deleted** | JMeter (Load) |
| TC-Perf-3 | **validate bio updated** | JMeter (Load) |

---

## 5. Specific Framework Tools Description

### Core Libraries and Concepts

* **PageObject Architecture:** Structured $\text{TC} \rightarrow \text{BO} \rightarrow \text{PO}$ hierarchy for improved readability and maintainability.
* **PageFactory:** Used for the initialization of Page Objects and their elements.
* **WebElement Wrappers:** Wrappers for UI elements that add extra logic (e.g., implicit waits, action logging) and enhance reliability.
* **Object Wrappers (API):** Wrapper classes for DTOs (Data Transfer Objects) to simplify working with JSON/XML requests and responses.
* **ORM (Object-Relational Mapping):** Used for handling test data (generating unique data, pre-validating DB states).
* **DriverPool:** Ensures efficient management and cross-browser reuse of WebDriver instances (Chrome, Firefox).

### Test Runners and Data Handling

* **Test Runners:** JUnit / TestNG (Insert applicable)
* **Assertion Libraries:** Built-in Test Runner tools or AssertJ.
* **DataProvider:** Used to run the same test with different sets of data.

### Reporting Utilities

* **Allure Framework:** The main reporting tool, providing interactive reports.
* **Logging:** Detailed logging of all actions.
    * **UI Tests:** Logging with **screenshot attachments** on failures or key steps.
    * **API Tests:** Logging with **JSON attachments** (requests/responses) for easy debugging.

### CI Integrations

* Integration with Jenkins/GitLab CI/GitHub Actions (Insert applicable) for automatic test execution and Allure report publication.

### Folder structure

Standard Maven/Gradle structure. Organization by layers: `src/main/java` (Framework Core), `src/test/java` (Tests/BO/PO), `src/test/resources` (TestData/Configs).

### How configuration and environments are handled

Configurations (URLs, credentials, API keys) are stored in `.properties`, `.yaml` files, or via Environment Variables. Environment selection (DEV/PROD) is done via command-line parameters or a configuration file.

---

## 8. Performance Workload Model Description

### User groups

* **Active Users (80%):** Creating, liking, deleting posts.
* **Passive Users (20%):** Viewing profiles, updating bios.

### Load distribution

Scenarios are distributed across a minimum of **3 ThreadGroups** in JMeter to simulate parallel load on different business functions:

1.  **ThreadGroup 1 (Post Operations):** $\text{validate post created, validate post deleted}$
2.  **ThreadGroup 2 (Profile Update):** $\text{validate bio updated}$
3.  **ThreadGroup 3 (Peak Load):** Simulating peak user login/logout traffic.

### RPS (requests per second)

* **Expected Peak Load RPS:** [Insert expected value, e.g., 100 RPS]
* **Target Load RPS:** [Insert target value, e.g., 80% of peak]

### ⏳ Test duration

[e.g., 30 minutes of steady load]

### Ramp-up / ramp-down

* **Ramp-up:** [e.g., 5 minutes]
* **Ramp-down:** [e.g., 2 minutes]

### System SLAs / SLOs

| Metric | SLA/SLO (90th Percentile) |
| :--- | :--- |
| $\text{validate post created}$ | [e.g., $< 500$ ms] |
| $\text{validate bio updated}$ | [e.g., $< 300$ ms] |
| Error Rate | $< 1\%$ |

---

## 9. Performance Scenario Description

| Scenario ID | Business flow | Purpose | Metrics to observe |
| :--- | :--- | :--- | :--- |
| **P-SCEN-1** | $\text{validate post created}$ | **Load/Endurance** | Latency, Throughput, Error Rate, CPU/Memory (Application Server) |
| **P-SCEN-2** | $\text{validate post deleted}$ | **Load/Stress** | Latency, Throughput, Database Connections, Error Rate |
| **P-SCEN-3** | $\text{validate bio updated}$ | **Load** | Latency, Throughput, Error Rate |

### Step-by-step scenario logic (Example: P-SCEN-1 - validate post created)

1.  **Entry Criteria:** User is authenticated.
2.  **Step 1:** HTTP Request GET /profile (Warm-up).
3.  **Step 2:** HTTP Request POST /posts (Create a new post with a unique ID).
4.  **Step 3:** HTTP Request GET /posts/{new\_post\_id} (Validate the post was created).

### Expected system behavior

The system must sustain the target RPS and adhere to the established SLOs without significant increases in latency or errors.

### Entry criteria

* The test environment is stable and meets requirements.
* Automated functional tests (WEB UI/API) have passed successfully.
* Sufficient and realistic test data set is available.

### Dependencies

Dependence on the operability of the Supabase DB and authentication service.
