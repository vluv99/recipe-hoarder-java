package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.ShoppingList_Item;
import com.vluv.recipe_hoarder_core.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/shoppingList-add")
public class ShoppingListController extends HttpServlet {
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
        request.setCharacterEncoding("UTF-8");

        UserDAO userDAO = Database.getInstance().getUserDAO();

        ShoppingList_Item shoppingList_item = new ShoppingList_Item(); //add item

        shoppingList_item.setUserId(currentUser.getId());
        shoppingList_item.setName_amount(request.getParameter("list-item"));

        userDAO.addShoppingListIngredient(shoppingList_item);
        currentUser.getShoppingList().add(shoppingList_item);

        response.sendRedirect("../shopping-list.jsp");
    }
}
