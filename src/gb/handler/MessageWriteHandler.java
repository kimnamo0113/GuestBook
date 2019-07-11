package gb.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gb.controller.CommandHandler;
import gb.model.Message;
import gb.service.MessageWriteService;

public class MessageWriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "messageWriteForm.jsp";
		}
		else if(req.getMethod().equalsIgnoreCase("post")) {
			req.setCharacterEncoding("utf-8");
			
			String guest_name = req.getParameter("guest_name");
			String password = req.getParameter("password");
			String message = req.getParameter("message");
			MessageWriteService service = MessageWriteService.getInstance();
			Message msg=new Message();
			msg.setGuest_name(guest_name);
			msg.setPassword(password);
			msg.setMessage(message);
			int result = service.write(msg);
			req.setAttribute("res", result);
			return "messageWriteResult.jsp";
		}
		return null;
	}

}
