package project.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {
    public static UserDAO getUserDAO() throws SQLException, ClassNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\1999g\\Downloads\\stepic_java_webserver-master\\stepic_java_webserver-master\\CRUD\\src\\main\\resources\\config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        if (properties.getProperty("dao").equalsIgnoreCase("jdbc")){
            return new UserJDBCDAO();
        }
        else{
            return new UserHibernateDAO();
        }

    }

}
