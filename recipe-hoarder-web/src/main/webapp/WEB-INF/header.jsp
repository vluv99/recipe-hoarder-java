<%--
  Created by IntelliJ IDEA.
  User: vluva
  Date: 5/6/2020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <div class="pos-f-t">
        <div class="collapse" id="navbarToggleExternalContent">
            <div class="bg-dark p-4">
                <ul class="list-inline">
                    <h5 class="text-white h4 list-inline-item">Menu</h5>
                    <div class="list-inline-item text-white d-inline-flex p-2 bd-highlight border border-white rounded" style="margin:10px">You are logged in as &#32; <div style="margin-left: 5px" class="font-weight-bold text-white"> &#32;  <%= request.getSession().getAttribute("email")%>
                        </div>
                    </div>
                </ul>
                <a href="recipe-sum.jsp"><span style="margin: 10px" class="text-white"> Recipes </span></a>
                <a href="add-recipe.jsp"><span style="margin: 10px" class="text-white"> Add Recipe </span></a>
                <a href="menu-sum.jsp"><span style="margin: 10px" class="text-white"> Menus </span></a>
                <a href="shopping-list.jsp"><span style="margin: 10px" class="text-white"> Shopping List </span></a>
                <a href="log-out"><span style="margin: 10px" class="text-white"> Log Out </span></a>

            </div>
        </div>
        <nav class="navbar navbar-dark bg-dark d-flex justify-content-start">
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div style="margin-left: 10px" class="text-white font-weight-lighter">Recipe-hoarder</div>
        </nav>
    </div>
</header>