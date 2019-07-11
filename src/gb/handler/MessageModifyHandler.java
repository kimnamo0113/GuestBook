package gb.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gb.controller.CommandHandler;
import gb.model.Message;
import gb.service.MessageUpdateService;

public class MessageModifyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int MessageId=Integer.parseInt(req.getParameter("id"));
			MessageUpdateService selMsg=MessageUpdateService.getInstance();
			Message msg=selMsg.select(MessageId);
			req.setAttribute("msg", msg);
			return "modifyForm.jsp";
		}
		else if(req.getMethod().equalsIgnoreCase("post")) {
			int message_id=Integer.parseInt(req.getParameter("message_id"));
			String newPassword=req.getParameter("newPassword");
			String originPassword=req.getParameter("originPassword");
			String message=req.getParameter("message");
			Message msg=new Message();
			msg.setMessage(message);
			msg.setPassword(originPassword);
			msg.setMessage_id(message_id);
			MessageUpdateService update = MessageUpdateService.getInstance();
			int result=update.update(msg,newPassword);
			req.setAttribute("res", result);
			req.setAttribute("msg", msg);
			if(result==-2)
				return "modifyForm.jsp";
			else
				return "modifyResult.jsp";
		}
		return null;
	}

}
