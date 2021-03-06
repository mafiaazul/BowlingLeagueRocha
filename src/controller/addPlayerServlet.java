package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;
import model.Team;

/**
 * Servlet implementation class addPlayerServlett
 */
@WebServlet("/addPlayerServlet")
public class addPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		String pn = request.getParameter("phoneNumber");
		String sn = request.getParameter("screenName");
		String tn = request.getParameter("teamName");
		
		Team team;
		TeamHelper th = new TeamHelper();
		PlayerHelper ph = new PlayerHelper();
		if (th.findTeamByName(tn) == null) {
			team = new Team(tn);
			th.insertTeam(team);
		} else {
			team = th.findTeamByName(tn);
		}
		Player player = new Player(fn, ln, pn, sn, team);
		ph.insertPlayer(player);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
