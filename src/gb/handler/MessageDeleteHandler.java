package gb.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gb.controller.CommandHandler;
import gb.service.MessageDeleteService;

public class MessageDeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			String id=req.getParameter("id");
			req.setAttribute("id", id);
			
			
			return "messageDeleteForm.jsp";
		}
		if(req.getMethod().equalsIgnoreCase("post")) {
			req.setCharacterEncoding("utf-8");
			String password=req.getParameter("password");
			int messageId = Integer.parseInt(req.getParameter("id"));
			//message 클래스의 내용을 db에 insert 되도록 처리
			MessageDeleteService service = MessageDeleteService.getInstance();
			int result = service.deleteMessage(messageId, password);
			req.setAttribute("res", result);
			req.setAttribute("id", messageId);
			return "messageDeleteForm.jsp";
			
		}
		return null;
	}

}
