# SHL-Assessment-Recommendation
it will recommend the basic assessments based on the query we enter
SHL Assessment Recommendation System - Project Approach
-------------------------------------------------------------------------------------------------------------------

 Overview
-------------------

The SHL Assessment Recommendation System is a Java Spring Boot web application designed to simplify the selection of relevant SHL assessments based on natural language job descriptions or queries. It aims to help hiring managers quickly identify appropriate tests aligned with specific roles, required skills, and time constraints.

## Approach
----------------------------

### 1. Data Collection and Structuring
---------------------------------------------------------------------

- Curated a dataset of SHL assessments extracted and modeled from SHL's public product catalog.
- Each assessment includes key attributes: name, URL, remote testing support, adaptive/IRT support, duration, and test type.
- Expanded dataset coverage to include several domains such as software development (Java, QA), sales roles, executive leadership (COO), content writing, and niche roles like ICICI Bank Assistant Admin.

### 2. Backend Implementation
---------------------------------------------------


- Developed a Spring Boot backend to serve as the core recommendation engine.
- Created an `Assessment` model representing assessment details.
- Implemented `AssessmentService` that:
  - Initializes and manages the assessment dataset.
  - Builds a keyword index (inverted index) to enable efficient keyword-based search.
  - Parses and normalizes durations to filter assessments by approximate test length.
  - Matches user queries against keywords and durations for precise recommendations.

### 3. Natural Language Query Processing
----------------------------------------------------------------------


- Extract keywords from queries using tokenization and normalization (lowercasing, punctuation removal).
- Extract and interpret time durations mentioned in queries using regular expressions.
- Filter assessments to match query keywords and duration constraints within a tolerance range.

### 4. Dynamic, Context-Aware Response Generation
---------------------------------------------------------------------------------

- Crafted role-specific summary texts for key domains (Sales, COO, QA Engineer, Content Writer, ICICI Assistant Admin, Creative Radio Roles).
- Summary text generation dynamically adapts based on query content for enhanced user understanding.
- Provided clickable links for assessments directly in the summary for easy access.

### 5. Frontend Design
--------------------------------------

- Integrated Thymeleaf templating engine to build a responsive web UI.
- Single input form for queries, displaying both a human-readable summary and a detailed tabular list of recommendations.
- Responsive and mobile-friendly CSS styling for improved usability.

## Tools and Libraries Used
------------------------------------------


- **Language & Framework:** Java 17, Spring Boot 3.0.6 for rapid RESTful web app development.
- **Template Engine:** Thymeleaf for dynamic server-side HTML rendering.
- **Data Processing:** Java streams, collections, regex for text parsing and filtering.
- **Build Tool:** Maven for dependency and build lifecycle management.

## Outcome
------------------------

- Developed a scalable, extensible recommendation engine with efficient lookup strategies.
- Created a user-friendly interface delivering actionable assessment recommendations that reflect job context and time parameters.
- The project supports expanding assessments and query processing logic for future domain-specific enhancements.

## How to Run
------------------------------

1. Build the project: `mvn clean package`
2. Run the packaged jar: `java -jar target/shl-assessment-recommendation-1.0.0.jar`
3. Access the web app at: `http://localhost:8080`

 Summary
------------------

This project leverages modern Java web technologies and strong NLP basics to deliver an intelligent SHL assessment recommendation system, reducing hiring managers' time in test selection while maintaining relevance and clarity.
