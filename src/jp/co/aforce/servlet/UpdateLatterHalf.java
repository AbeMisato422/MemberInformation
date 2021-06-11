package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MembersBean;
import jp.co.aforce.dao.MembersDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/updatelatterhalf"})
public class UpdateLatterHalf extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{

		PrintWriter out=response.getWriter();
		Page.header(out);


		String memberNo=request.getParameter("memberNo");
		String name=request.getParameter("name");

		String age1=request.getParameter("age");
		String birthYear1=request.getParameter("birthYear");
		String birthMonth1=request.getParameter("birthMonth");
		String birthDay1=request.getParameter("birthDay");


		if(memberNo=="" || name=="" || age1=="" || birthYear1=="" || birthMonth1=="" || birthDay1=="") {
			request.getRequestDispatcher("../jsp/update-error2.jsp").forward(request, response);
		}else {


			int age=Integer.parseInt(age1);//ParseIntをnullのときにやるとエラーだからこの位置
			int birthYear=Integer.parseInt(birthYear1);
			int birthMonth=Integer.parseInt(birthMonth1);
			int birthDay=Integer.parseInt(birthDay1);


			try {
				MembersBean membersBean=new MembersBean();
				membersBean.setMemberNo(memberNo);
				membersBean.setName(name);
				membersBean.setAge(age);
				membersBean.setBirthYear(birthYear);
				membersBean.setBirthMonth(birthMonth);
				membersBean.setBirthDay(birthDay);

				MembersDAO dao=new MembersDAO();
				int line=dao.update(membersBean);

				if(line>0) {
					out.println("変更に成功しました");
				}else {
					out.println("変更に失敗しました");
				}

			}catch(Exception e) {
				out.println("変更に失敗しました");
				//e.printStackTrace(out);
			}

		}

	Page.footer(out);
	}

}
