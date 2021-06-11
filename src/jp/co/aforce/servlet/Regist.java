package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.aforce.tool.Page;


@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/regist"})
public class Regist extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{

		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/database");
			Connection con=ds.getConnection();

			Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
			String str = sdf.format(timeStamp);

			String name=request.getParameter("name");
			String age1=request.getParameter("age");
			String birthYear1=request.getParameter("birthYear");
			String birthMonth1=request.getParameter("birthMonth");
			String birthDay1=request.getParameter("birthDay");

			if(name=="" || age1=="" || birthYear1=="" || birthMonth1=="" || birthDay1=="") {
				request.getRequestDispatcher("../jsp/update-error2.jsp").forward(request, response);
			}else {

				int age=Integer.parseInt(age1);
				int birthYear=Integer.parseInt(birthYear1);
				int birthMonth=Integer.parseInt(birthMonth1);
				int birthDay=Integer.parseInt(birthDay1);


				PreparedStatement st=con.prepareStatement(
						"insert into members values(?, ?, ?, ?, ?, ?)");
				st.setString(1, "A"+str);
				st.setString(2, name);
				st.setInt(3, age);
				st.setInt(4, birthYear);
				st.setInt(5, birthMonth);
				st.setInt(6, birthDay);
				int line=st.executeUpdate();

				if(line>0) {
					out.println("登録に成功しました");
				}

				st.close();
				con.close();

			}
		}catch (Exception e) {
			out.println("登録に失敗しました");

		}
		Page.footer(out);
	}

}
