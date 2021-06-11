package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jp.co.aforce.beans.MembersBean;
import jp.co.aforce.dao.MembersDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/deletelatterhalf"})
public class DeleteLatterHalf extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{

		PrintWriter out=response.getWriter();
		Page.header(out);


		try {
			String memberNo=request.getParameter("memberNo");
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			int birthYear=Integer.parseInt(request.getParameter("birthYear"));
			int birthMonth=Integer.parseInt(request.getParameter("birthMonth"));
			int birthDay=Integer.parseInt(request.getParameter("birthDay"));

			MembersDAO dao=new MembersDAO();
			int line=dao.delete(memberNo);

			if(line>0) {
				out.println("削除に成功しました");
			}else {
				out.println("削除に失敗しました");
			}

		}catch(Exception e) {
			e.printStackTrace(out);
		}

	}

}
