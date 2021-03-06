package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeedbackDao;
import model.Feedback;

/**
 * Servlet implementation class FeedbackFindAndUpdate
 */
@WebServlet("/FeedbackUpdate")
public class FeedbackFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FeedbackFindAndUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int feedbackId = Integer.parseInt(request.getParameter("feedbackId"));
		Feedback feedback = FeedbackDao.findByPk(feedbackId);
		
		request.setAttribute("feedback", feedback);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Feedback feedback = new Feedback();
		
		feedback.setId_feedback(Integer.parseInt(request.getParameter("id")));
		feedback.setData(request.getParameter("data"));
		feedback.setDescricao(request.getParameter("descricao"));
		
		FeedbackDao.update(feedback);
		
		FeedbackCreateAndFind feedbackCreateAndFind = new FeedbackCreateAndFind();
		feedbackCreateAndFind.doGet(request, response);
	}

}
