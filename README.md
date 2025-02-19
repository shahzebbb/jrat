# jrat

**jrat** is a personal project that I developed to learn Java programming. It provides a simple Command Line Interface (CLI) with basic version control commands: `log`, `init`, `commit`, and `checkout`.

## Features

- **log**: Display commit logs.
- **init**: Initialize a new repository.
- **commit**: Commit changes to the repository.
- **checkout**: Switch between different commits.

## Prerequisites

- **Java Development Kit (JDK)**: This project was built using JDK 21. I have not tested it on other versions.
- **Apache Maven**: Used for build automation.

## Building the Project

To build the `jrat` project:

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/shahzebbb/jrat.git
   cd jrat
   ```

2. **Compile and Package**:
   Use Maven to compile the project and package it into a JAR file:
   ```sh
   mvn clean package
   ```
   The packaged JAR file will be located in the `target` directory.

## Running the CLI Tool

After building the project:

1. **Navigate to the Target Directory**:
   ```sh
   cd target
   ```

2. **Execute the JAR File with Desired Command**:
   ```sh
   java -jar jrat.jar <command>
   ```
   Replace `<command>` with one of the available commands: `log`, `init`, `commit`, or `checkout`.

   **Examples**:
   - To view commit logs:
     ```sh
     java -jar jrat.jar log
     ```
   - To initialize a new repository:
     ```sh
     java -jar jrat.jar init
     ```

## Creating a Shortcut for Convenience

To simplify usage, create a shortcut:

### On Unix/Linux/macOS:

1. **Create a Shell Script**:
   Create a file named `jrat` with the following content:
   ```sh
   #!/bin/bash
   java -jar /path/to/jrat.jar "$@"
   ```
   Replace `/path/to/jrat.jar` with the actual path to your `jrat.jar` file.

2. **Make the Script Executable**:
   ```sh
   chmod +x jrat
   ```

3. **Move the Script to a Directory in Your PATH**:
   ```sh
   sudo mv jrat /usr/local/bin/
   ```

Now, you can run the tool using:
```sh
jrat <command>
```

Now, you can run the tool using:
```sh
jrat <command>
```
