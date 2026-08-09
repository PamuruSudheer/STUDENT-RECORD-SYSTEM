import java.sql.*;
import java.util.*;

public class StudentRecordSystem {

    // PostgreSQL database details
    static final String URL =
            "jdbc:postgresql://localhost:5432/studentdb";

    static final String USER = "postgres";
    static final String PASSWORD = "your_password";


    // ============================
    // DATABASE CONNECTION
    // ============================

    public static Connection getConnection() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();
        }

        return con;
    }


    // ============================
    // ADD STUDENT
    // ============================

    public static void addStudent(
            String name,
            int age,
            String course,
            String email) {

        String sql =
                "INSERT INTO student " +
                "(student_name, student_age, student_course, student_email) " +
                "VALUES (?, ?, ?, ?)";

        try (
                Connection con = getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Student added successfully."
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // ============================
    // VIEW ALL STUDENTS
    // ============================

    public static void viewAllStudents() {

        String sql =
                "SELECT * FROM student ORDER BY student_id";

        try (
                Connection con = getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql);
                ResultSet rs =
                        ps.executeQuery()
        ) {

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println();
                System.out.println("----------------------------");

                System.out.println(
                        "ID     : " +
                        rs.getInt("student_id")
                );

                System.out.println(
                        "Name   : " +
                        rs.getString("student_name")
                );

                System.out.println(
                        "Age    : " +
                        rs.getInt("student_age")
                );

                System.out.println(
                        "Course : " +
                        rs.getString("student_course")
                );

                System.out.println(
                        "Email  : " +
                        rs.getString("student_email")
                );

                System.out.println("----------------------------");
            }

            if (!found) {

                System.out.println(
                        "No students found."
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // ============================
    // SEARCH STUDENT BY ID
    // ============================

    public static void searchStudent(int id) {

        String sql =
                "SELECT * FROM student WHERE student_id = ?";

        try (
                Connection con = getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println();
                System.out.println("Student Found");
                System.out.println("----------------------------");

                System.out.println(
                        "ID     : " +
                        rs.getInt("student_id")
                );

                System.out.println(
                        "Name   : " +
                        rs.getString("student_name")
                );

                System.out.println(
                        "Age    : " +
                        rs.getInt("student_age")
                );

                System.out.println(
                        "Course : " +
                        rs.getString("student_course")
                );

                System.out.println(
                        "Email  : " +
                        rs.getString("student_email")
                );

                System.out.println("----------------------------");

            } else {

                System.out.println(
                        "Student not found."
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // ============================
    // UPDATE STUDENT
    // ============================

    public static void updateStudent(
            int id,
            String name,
            int age,
            String course,
            String email) {

        String sql =
                "UPDATE student SET " +
                "student_name = ?, " +
                "student_age = ?, " +
                "student_course = ?, " +
                "student_email = ? " +
                "WHERE student_id = ?";

        try (
                Connection con = getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Student updated successfully."
                );

            } else {

                System.out.println(
                        "Student not found."
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // ============================
    // DELETE STUDENT
    // ============================

    public static void deleteStudent(int id) {

        String sql =
                "DELETE FROM student WHERE student_id = ?";

        try (
                Connection con = getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Student deleted successfully."
                );

            } else {

                System.out.println(
                        "Student not found."
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    // ============================
    // MAIN METHOD
    // ============================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println(
                    "================================"
            );

            System.out.println(
                    "      STUDENT RECORD SYSTEM"
            );

            System.out.println(
                    "================================"
            );

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.println(
                    "================================"
            );

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter student email: ");
                    String email = sc.nextLine();
                    addStudent(name, age, course, email);
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int searchId = sc.nextInt();
                    searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    updateStudent(updateId, newName, newAge, newCourse, newEmail);
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    int deleteId = sc.nextInt();
                    deleteStudent(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you for using Student Record System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
