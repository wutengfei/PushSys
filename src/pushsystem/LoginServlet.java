package pushsystem;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import config.ConfigLoader;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("####LoginServlet doGet####");
		Boolean flag = false;
		String loginInfo = null;
		// 获取http请求response的输入流，用于向客户端返回数据
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		logger.debug("用户登录：" + "  userName：" + userName + "  passWord:" + passWord);
		System.out.println("用户登录：" + "  userName：" + userName + "+passWord:" + passWord + "+");
		flag = connectDataBase(userName, passWord);

		if (flag) {
			loginInfo = "login_success";
			logger.debug(userName + ":登录成功");
			System.out.println(userName + ":登录成功");
		} else {
			logger.debug(userName + ":登录失败");
			System.out.println(userName + ":登录失败");
			loginInfo = "login_fail";// "login_fail"
		}
		out.write(loginInfo);
		out.flush();
		out.close();
	}

	public boolean connectDataBase(String userName, String passWord) {
		Connection con = null;
		Statement statement = null;
		String query = null;
		ResultSet result = null;
		boolean res = false;
		try {
			Class.forName(ConfigLoader.getPropertyByName("db_driver"));
			String url = ConfigLoader.getPropertyByName("url");
			String db_uname = ConfigLoader.getPropertyByName("db_uname");
			String db_pword = ConfigLoader.getPropertyByName("db_pword");
			con = (Connection) DriverManager.getConnection(url, db_uname, db_pword);

			statement = (Statement) con.createStatement();
			query = "SELECT * FROM user where userName ='" + userName + "'and passWord ='" + passWord + "'";
			result = statement.executeQuery(query);
			if (result.next()) {
				res = true;
			} else {
				System.out.println("没有此用户");
				res = false;
			}
		} catch (Exception e) {

			logger.debug(e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			con.close();
			statement.close();
			result.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return res;
	}

//	String name = request.getParameter("name");
//	String pass = request.getParameter("pass");System.out.println(name+"-----"+pass);
//	OutputStream os = response.getOutputStream();if("123".equals(name)&&"123".equals(pass))
//	{
//
//		os.write("login success".getBytes("utf-8"));
//	}else
//	{
//		os.write("login fail".getBytes("utf-8"));
//	}

	// String comment=request.getParameter("comment");
	// if(!comment.trim().equals("")){
	// os.write("submit success".getBytes("utf-8"));
	// }else{
	// os.write("submit fail".getBytes("utf-8"));
	// }
	String user = "1";

	// String time1 = request.getParameter("time1");
	// String content1 = request.getParameter("content1");
	// String remark1 = request.getParameter("remark1");

	UserDAO userDao = new UserDAO();
	// PlanBean plan = new PlanBean(user, "1", time1, content1, remark1);

	// if (userDao.insert(plan) > 0) {
	// os.write("success".getBytes("utf-8"));
	// }

	/*
	 * for (int i = 1; i <= 20; i++) { String time =
	 * request.getParameter("time"+i); String content =
	 * request.getParameter("content"+i); String remark =
	 * request.getParameter("remark"+i); PlanBean plan = new PlanBean(user,
	 * ""+i, time, content, remark); userDao.insert(plan); }
	 * os.write("success".getBytes("utf-8"));
	 */
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
