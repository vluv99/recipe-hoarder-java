package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.ShoppingList_Item;
import com.vluv.recipe_hoarder_core.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/shoppingList-delete")
public class DeleteShoppingList_ItemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("WEB-INF/add-recipe.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        UserDAO userDAO = Database.getInstance().getUserDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteShoppingListIngredient(id);

        for (int i = 0; i < currentUser.getShoppingList().size(); i++){
            if (id == currentUser.getShoppingList().get(i).getId()){
                currentUser.getShoppingList().remove(i);
                break;
            }
        }
        response.sendRedirect("../shopping-list.jsp");
    }
}
