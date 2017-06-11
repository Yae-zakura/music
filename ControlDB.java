package music;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.scene.layout.region.Margins.Converter;

/*编写ControlDB类对数据库的操作*/
public class ControlDB {
	private static ControlDB control = null;

	private ControlDB() {

	}

	/* 创建getInstance()方法，获得一个ControlDB对象的实例 */
	public static ControlDB getInstance() {
		if (control == null) {
			control = new ControlDB();
		}
		return control;
	}

	/* 创建executeQuery()方法，执行Select语句 */
	public ResultSet executeQuery(String sql) throws Exception {
		ResultSet rs = null;
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			throw e;
		}
		return rs;
	}

	/* 创建selectSystemInfo()方法查询网站设置信息 */
	public Systems selectSystemInfo(String sql) throws Exception{
		Systems sys=new Systems;
		ResultSet rs=this.executeQuery(sql);
		if(rs.next()){
			int i=1;
			sys.setId(rs.getInt(i++));
			sys.setName(rs.getString(i++));
			sys.setLogopath(rs.getString(i++));
			sys.setNotice(rs.getString(i++));
		}
		return sys;
	}

	/* 创建checkAdmin()方法检查管理员账号和密码 */
	public Admin checkAdmin(String sql) throws Exception {
		Admin admin = new Admin();
		ResultSet rs = this.executeQuery(sql);
		if (rs.next()) {
			int i = 1;
			admin.setId(rs.getInt(i++));
			admin.setName(rs.getString(i++));
			admin.setPassword(rs.getString(i++));
		}
		return admin;
	}

	/* 创建selectType()方法查询所有音乐分类信息 */
	public List<Type> selectType(String sql) throws Exception {
		List<Type> list = new ArrayList<Type>();
		ResultSet rs = executeQuery(sql);
		ConvertUtil convert = ConvertUtil.getInstance();
		while (rs.next()) {
			int i = 1;
			Type type = new Type();
			type.setId(rs.getInt(i++));
			type.setName(rs.getString(i++));
			type.setExplain(rs.getString(i++));
			type.setNum(convert.strtoInt(rs.getString(i++)));
			type.setContenttime(rs.getString(i++));
			list.add(type);
		}
		return list;
	}

	/* 创建selectAllMusicById()方法，根据分类的名称查询相关的音乐 */
	public List<Type> selectAllMusicById(String aql) throws Exception {
		List<Type> list = new ArrayList<Type>();
		ResultSet rs = executeQuery(sql);
		ConvertUtil convert = ConvertUtil.getInstance();
		while (rs.next()) {
			int i = 1;
			Type type = new Type();
			type.setId(rs.getInt(i++));
			type.setName(rs.getString(i++));
			type.setExplain(rs.getString(i++));
			type.setNum(convert.strToInt(rs.getString(i++)));
			type.setContenttime(rs.getString(i++));
			list.add(type);
		}
		return list;
	}

	/* 创建selectMusic()方法查询所有音乐信息 */
	public List<Music> selectMusic(String aql) throws Exception {
		List<Music> list = new ArrayList<Music>();
		ResultSet rs = executeQuery(sql);
		ConvertUtil convert = ConvertUtil.getInstance();
		while (rs.next()) {
			int i = 1;
			Music music = new Music();
			music.setId(rs.getInt(i++));
			music.setName(rs.getString(i++));
			music.setPath(rs.getString(i++));
			music.setClick(rs.getInt(i++));
			music.setContentTime(rs.getString(i++));
			music.setExplain(rs.getString(i++));
			music.setLid(rs.getString(i++));
			list.add(music);
		}
		return list;
	}

	/* 创建executeQueryComment()方法查询相关评论 */
	public List<Comment> executeQueryComment(String aql) throws Exception {
		List<Comment> list = new ArrayList<Comment>();
		ResultSet rs = executeQuery(sql);
		while (rs.next()) {
			int i = 1;
			Comment comment = new Comment();
			comment.setId(rs.getInt(i++));
			comment.setContentText(rs.getString(i++));
			comment.setContentTime(rs.getString(i++));
			comment.setName(rs.getString(i++));
			comment.setPid(rs.getString(i++));
			list.add(comment);
		}
		return list;
	}

	/* 创建executeUpdate()方法执行所有修改的操作 */
	public boolean executeUpdate(String sql) throws Exception {
		boolean flag = false;
		Connection con = null;
		Statement = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
			int row = stmt.executeUpdate(sql);
			flag = row > 0 ? true : false;
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			flag = false;
		} finally {
			DatabaseUtils.closeObject(stmt, con);
		}
		return flag;
	}
}
