package gb.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gb.controller.CommandHandler;
import gb.model.Message;
import gb.service.MessageListService;

public class MessageListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		MessageListService service = MessageListService.getInstance();
		List<Message> list = service.getMessageList();
		
		req.setAttribute("list", list);
		return "messageList.jsp";
	}

}
