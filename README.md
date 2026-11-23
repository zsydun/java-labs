# Лабораторні роботи з Java

Сідун Євгеній К., група 124-23-1, НТУ «Дніпровська політехніка».

| ЛР | Тема | Пакет / точка входу |
|----|------|---------------------|
| 0 | Hello world | `ua.sidun.lab0.HelloWorld` |
| 1 | CVS. Git | гілки `LR_0` … `LR_5`, змерджені в `master` |
| 2 | Основи (матриця) | `ua.sidun.lab2.MatrixApp` |
| 3 | ООП (MVC, університет) | `ua.sidun.lab3.Run` |
| 4 | JUnit. Json | `ua.sidun.lab4.Run`, тест `UniversityJsonTest` |
| 5 | JDBC | `ua.sidun.lab5.StudentBirthdayApp` |

## Збірка та тести

```
mvn clean test
```

## ЛР 5: база даних

1. Встановити PostgreSQL.
2. Виконати `psql -U postgres -f src/main/resources/database.sql`.
3. За потреби змінити логін і пароль у `src/main/resources/db.properties`.
