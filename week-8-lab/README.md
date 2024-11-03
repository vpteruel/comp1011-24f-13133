
# Student Management Project

This project demonstrates the management of student records using Java collections, such as `HashSet`, `TreeSet`, and `Stack`. The project includes three classes that manage student records, each class leveraging different Java collections for specific functionalities.

## Project Structure

- `Student`: A class that represents a student with attributes `id`, `name`, and `email`. It includes `equals()` and `hashCode()` methods for unique identification based on the `id` attribute, and it implements `Comparable<Student>` to allow sorting by `name`.
- `HashSetOperations`: Manages a collection of students using `HashSet` to ensure no duplicates by `id`.
- `TreeSetOperations`: Manages a collection of students using `TreeSet` to keep them sorted by `name`.
- `StackOperations`: Manages a stack of recently added students.

## Requirements

- **Java Development Kit (JDK)**: Version 17 or later
- **Maven**: Version 3.6 or later

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/vpteruel/comp1011-24f-13133.git
   ```
2. Navigate into the project directory:
   ```bash
   cd week-8-lab/working-with-collections
   ```
3. Compile the project:
   ```bash
   mvn compile
   ```

## Usage

To run the project, use the following command:
```bash
mvn exec:java -Dexec.mainClass="com.vinicius.Main"
```

The main class demonstrates adding students to the `HashSet`, `TreeSet`, and `Stack` collections, as well as displaying the contents of each.

## Testing

Unit tests are provided for each collection manager class to validate functionality:
- `HashSetOperationsTest`
- `TreeSetOperationsTest`
- `StackOperationsTest`

To run the tests and generate a test report:
```bash
mvn test
```

### Generating an HTML Test Report

1. Run the following command to create an HTML report of the test results:
   ```bash
   mvn surefire-report:report-only
   ```
2. Open the report located at:
   ```
   target/reports/surefire.html
   ```

## License

This project is licensed under the MIT License.
