package pushsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

	private static final String GET_ONE_SQL = "SELECT * FROM username "
			+ "WHERE username = ? and password = ? and type = ?";

	public UserDAO() {
	}

	public Connection getConnection() {

		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://127.0.0.1/pushsystem";
		String username = "root";// 数据库登录用户名
		String password = "123456";// 数据库登录密码
		try {
			Class.forName(driver);// 加载驱动程序

			conn = DriverManager.getConnection(dburl, username, password);
		
		} catch (Exception e) {
			e.printStackTrace();}
			return conn ;
		}
	public int insert(PlanBean plan){
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into teachplan(user,week,time,content,remark)values(?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getUser());
			pstmt.setString(2, plan.getWeek());
			pstmt.setString(3, plan.getTime());
			pstmt.setString(4, plan.getContent());
			pstmt.setString(5, plan.getRemark());
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;		
	}
	
}
