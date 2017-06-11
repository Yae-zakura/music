package music;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	/* 设置数据库的驱动类 */
	private String driver = "";
	/* 设置数据库的URL */
	private String dbURL = "";
	/* 设置数据库的用户名 */
	private String user = "";
	/* 设置数据库的用户密码 */
	private String password = "";
	/* 设置ConnectionFactory对象 */
	private static ConnectionFactory factory = null;

	public String getDbURL() {
		return dbURL;
	}

	public String getDriver() {
		return driver;
	}

	public String getPassword() {
		return password;
	}

	public String getUser() {
		return user;
	}

	/* 编写ConnectionFactory的构造方法，为属性赋值 */
	private ConnectionFactory() throws Exception {
		Properties prop = new Properties();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("data.properities");
		try {
			prop.load(is);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("加载文件出错");
		}
	}

	/* 编写getConnection()方法，与数据库链接 */
	public static Connection getConnection() {
		Connection conn = null;
		if (factory == null) {
			try {
				factory = new ConnectionFactory();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		try {
			Class.forName(factory.getDriver());
			conn = DriverManager.getConnection(factory.getDbURL(), factory.getUser(), factory.getPassword());
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("No class" + factory.getDriver() + "found error");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Failed to get connection:" + e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}
}
