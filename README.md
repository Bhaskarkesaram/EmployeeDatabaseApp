# 💼 Employee Database App – Java + MySQL (JDBC)

This is a simple **console-based Java application** that performs **CRUD operations** (Create, Read, Update, Delete) on an Employee table using **JDBC** and **MySQL**.

---

## 📋 Features

- ✅ Add Employee
- ✅ View All Employees
- ✅ Update Employee
- ✅ Delete Employee

---

## 🛠️ Tools & Technologies

- Java
- MySQL
- JDBC Driver (`mysql-connector-java`)
- VS Code / Terminal / IntelliJ

---

## 🏗️ Database Setup (MySQL)

1. Open **MySQL Workbench** or **Command Line**.
2. Run the following SQL:

```sql

CREATE DATABASE EmployeeDB;
USE EmployeeDB;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    position VARCHAR(100),📦 Project Structure
    salary DOUBLE
);

```

## 📦 Project Structure
employee-db-app/

├── EmployeeApp.java

├── lib/

│   └── mysql-connector-java-8.0.xx.jar

├── run.bat (optional for Windows)

└── README.md

## 📍 Option 1: Run from Terminal
Make sure to replace ```8.0.xx``` with the correct ```.jar``` version you downloaded.

## 🪟 Windows:
```
javac -cp .;lib\mysql-connector-java-8.0.xx.jar EmployeeApp.java

```
```
java -cp .;lib\mysql-connector-java-8.0.xx.jar EmployeeApp

```
## 🐧 Linux/macOS:
```
javac -cp .:lib/mysql-connector-java-8.0.xx.jar EmployeeApp.java

```
```
java -cp .:lib/mysql-connector-java-8.0.xx.jar EmployeeApp

```

## 📍 Option 2: Run via VS Code

-- Install Java Extension Pack from VS Code extensions.

-- Open the project folder in VS Code.

-- Right-click EmployeeApp.java → Run Java.

-- When prompted, add the MySQL connector .jar to the classpath.

## 🧪 Sample Output

=== Employee Database App ===
1. Add Employee
2. View All Employees
3. Update Employee
4. Delete Employee
5. Exit

   
Enter choice: 1

Enter name: Bharan

Enter position: Manager

Enter salary: 80000

1 employee(s) added.

   
## 🧰 Notes
-- Ensure MySQL server is running.

-- Update your MySQL username and password in the code:
```

private static final String DB_USER = "root";
private static final String DB_PASSWORD = "your_password";

```

## 🙌 Author
Bhaskar Kesaram
