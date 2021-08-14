package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
/* @WebServlet("/member") */
public class MemberServlet extends HttpServlet {
       

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table border='1'>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>");
		out.print("</tr>");
		
		// 디비에서 가져온걸로 뿌리자~
		for(int i=0; i < list.size(); i++) 
		{
			MemberVO memberVO = list.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr>");
			out.print("<td>"+ id + "</td>");
			out.print("<td>"+ pwd + "</td>");
			out.print("<td>"+ name + "</td>");
			out.print("<td>"+ email + "</td>");
			out.print("<td>"+ joinDate + "</td>");
			out.print("</tr>");
		}
		
		out.print("</table>");
		out.print("</body></html>");
		
		
		
		
		
	}

	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
	
}
