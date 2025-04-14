# ag25-ai-assistant

This repo is my frok from the [mwinteringham/ag25-ai-assistant](https://github.com/mwinteringham/ag25-ai-assistant). I use this repo to learn and practice experiments about Ai Agents in JAVA. 


## Added features:

* DevContainer setup on docker compose dev environment
    * Added `.devcontainer` configuration for VS Code
    * Includes Docker Compose setup for local development
    * Pre-configured Git and development tools
    * Ensures a reproduceble and consistent development environment

* Reset DB before each unit test
    * Implemented `@BeforeEach` step for the `DataQueryTest` test suite.
    * Added database reset logic
    * Ensures test isolation and prevents data interference
    * Tests can run in any order reliably

* Added LogBack as the log4j provider
    * Configured `logback.xml` for structured logging
    * Set up a default console logger for the code in this project.
    * Improved log formatting and readability
    
* **Added Retries logic with resilience4j**
    * Added retry mechanisms to recover from rate limiting errors
    * Configured fallback strategies
    




