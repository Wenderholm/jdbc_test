import javax.xml.crypto.Data;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "admin");
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT  first_name, last_name, hire_date FROM employees LIMIT 10");

//        1 SPOSOB POBIERANIA DANYCH Z BAZY DANYCH
        while(rs.next()){
            String firstName = rs.getString(1);
            String lastName = rs.getString(2);
            Date hireDate = rs.getDate(3);
            System.out.printf("%s %s - data zatrudnienia %s\n", firstName,lastName,hireDate.toString());
        }

//        2 SPOSOB POBIERANIA DANYCH Z BAZY DANYCH
        //        while (rs.next()) {
        //            String firstName = rs.getString("first_name");
        //            String lastName = rs.getString("last_name");
        //            Date hireDate = rs.getDate("hire_date");
        //            System.out.printf("%s %s - data zatrudnienia: %s\n", firstName, lastName, hireDate.toString());
        //        }

        int updateRows = statement.executeUpdate("UPDATE employees SET first_name = 'Piotr' WHERE emp_no = 10001");
        System.out.println("Zaktualizowano wierszy: " + updateRows);
//
//        Potencjalne problemy
//        Przy uruchamianiu programu mogą pojawić się różne problemy, które najczęściej można rozwiązać poprzez dodanie dodatkowych parametrów do adresu URL bazy danych.
//        Błąd The server time zone value 'CEST' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the 'serverTimezone' configuration property) to use a more specifc time zone value if you want to utilize time zone support.
//        Do adresu URL należy dodać parametr określający strefę czasową, np. jdbc:mysql://localhost:3306/employees?serverTimezone=UTC
//
//        Błąd Public Key Retrieval is not allowed.
//        Do adresu URL należy dodać dodatkowy parametr jdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true
//        Jeżeli występuje kilka błędów jednocześnie, to adresu bazy można dodać kilka parametrów, np. jdbc:mysql://localhost:3306/employees?serverTimezone=UTC&allowPublicKeyRetrieval=true
//
//        Błąd Access denied for user 'roots'@'localhost' (using password: YES)
//        Wprowadzona nazwa użytkownika lub hasło nie są poprawne. Sprawdź, czy nie ma w nich literówki.
    }
}
