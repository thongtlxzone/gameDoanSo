package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import service.GameService;

@WebServlet(name = "gameServlet", urlPatterns = {"/game"})
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("game.jsp").forward(req,resp);
    }
    static int answer = (int) Math.floor(Math.random() *(1000 - 1 + 1) + 1);
    static int countPoint = 0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = req.getParameter("name");
        int playerAnswer = Integer.parseInt(req.getParameter("answer"));
        System.out.println(answer);
        GameService gameService = new GameService();
        if(playerAnswer>answer){
            countPoint++;
            req.setAttribute("suggest","So vua doan lon hon dap an");
            req.getRequestDispatcher("game.jsp").forward(req,resp);
        } else if (playerAnswer<answer) {
            countPoint++;
            req.setAttribute("suggest","So vua doan nho hon dap an");
            req.getRequestDispatcher("game.jsp").forward(req,resp);
        }else {
            countPoint++;
            System.out.println(countPoint);
            req.setAttribute("suggest", "Chuc mung ban " + playerName + " da doan chinh xac voi " + countPoint + " lan thu!!!");
            req.getRequestDispatcher("game.jsp").forward(req, resp);
            answer = (int) Math.floor(Math.random() * (1000 - 1 + 1) + 1);
            countPoint = 0;
        }
    }
}
