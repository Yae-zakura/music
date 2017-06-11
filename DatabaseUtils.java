package music;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*DatabaseUtils类提供关闭链接、结果集、语句块的方法*/
public class DatabaseUtils {
	public static void closeObject(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("关闭Connection异常");
		}
	}

	public static void closeObject(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("关闭ResultSet异常");
		}
	}

	public static void closeObject(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("关闭Statement异常");
		}
	}

	/* 关闭语句块、链接 */
	public static void closeObject(Statement stm, Connection con) {
		closeObject(stm);
		closeObject(con);
	}

	/* 关闭结果集、语句块、链接 */
	public static void closeObject(ResultSet rs, Statement stm, Connection con) {
		closeObject(rs);
		closeObject(stm, con);
	}
}
