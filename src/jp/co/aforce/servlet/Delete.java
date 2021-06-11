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
@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/delete"})
public class Delete extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{

		PrintWriter out=response.getWriter();


		try {
			String memberNo=request.getParameter("memberNo");

			MembersDAO dao=new MembersDAO();
			MembersBean membersBean=dao.search(memberNo);

			if(membersBean!=null) {
				request.setAttribute("membersBean" , membersBean);//渡さないといけない引数（渡し先の入れ物名, bean名）
				request.getRequestDispatcher("../jsp/delete-display.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("../jsp/delete-error.jsp").forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace(out);
		}

	}

}

