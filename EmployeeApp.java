import java.sql.*;
import java.util.Scanner;

public class EmployeeApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String DB_USER = "root"; // Replace with your DB username
    private static final String DB_PASSWORD = ""; // Replace with your DB password
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Employee Database App ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private static void addEmployee() {
        try (Connection conn = connect()) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter position: ");
            String position = scanner.nextLine();
            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();

            String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, position);
            ps.setDouble(3, salary);

            int rows = ps.executeUpdate();
            System.out.println(rows + " employee(s) added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewEmployees() {
        try (Connection conn = connect()) {
            String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Position: %s | Salary: %.2f\n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("position"), rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateEmployee() {
        try (Connection conn = connect()) {
            System.out.print("Enter employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new position: ");
            String position = scanner.nextLine();
            System.out.print("Enter new salary: ");
            double salary = scanner.nextDouble();

            String sql = "UPDATE employees SET name=?, position=?, salary=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, position);
            ps.setDouble(3, salary);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " employee(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmployee() {
        try (Connection conn = connect()) {
            System.out.print("Enter employee ID to delete: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " employee(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
