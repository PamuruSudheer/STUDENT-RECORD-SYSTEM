# 🎓 STUDENT RECORD SYSTEM

A simple Java console application to manage student records using **PostgreSQL** database with full **CRUD** operations.

---

## 📋 Features

- ✅ Add Student
- ✅ View All Students
- ✅ Search Student by ID
- ✅ Update Student
- ✅ Delete Student

---

## 🛠️ Tech Stack

| Technology | Details         |
|------------|-----------------|
| Language   | Java            |
| Database   | PostgreSQL       |
| Connector  | JDBC            |

---

## 🗄️ Database Setup

Run the following SQL in PostgreSQL:

```sql
CREATE TABLE student (
    student_id     SERIAL PRIMARY KEY,
    student_name   VARCHAR(100) NOT NULL,
    student_age    INT          NOT NULL,
    student_course VARCHAR(100) NOT NULL,
    student_email  VARCHAR(100) UNIQUE
);
```

---

## ⚙️ Configuration

Open `src/StudentRecordSystem.java` and update these lines with your PostgreSQL credentials:

```java
static final String URL      = "jdbc:postgresql://localhost:5432/studentdb";
static final String USER     = "postgres";
static final String PASSWORD = "your_password";
```

---

## 🚀 How to Run

1. Install **PostgreSQL** and create a database named `studentdb`
2. Run the SQL script from `database/schema.sql`
3. Download the **PostgreSQL JDBC Driver** from https://jdbc.postgresql.org/
4. Compile and run:

```bash
javac -cp postgresql-42.x.x.jar src/StudentRecordSystem.java
java  -cp .:postgresql-42.x.x.jar StudentRecordSystem
```

> On Windows use `;` instead of `:` in the classpath

---

## 📁 Project Structure

```
StudentRecordSystem/
├── src/
│   └── StudentRecordSystem.java
├── database/
│   └── schema.sql
└── README.md
```

---

## 👤 Author

**Pamuru Sudheer**  
GitHub: [@PamuruSudheer](https://github.com/PamuruSudheer)
