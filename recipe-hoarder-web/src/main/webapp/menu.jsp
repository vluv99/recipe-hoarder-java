<%@ page import="com.vluv.recipe_hoarder_core.model.Menu" %>
<jsp:useBean id="currentUser" class="com.vluv.recipe_hoarder_core.model.User" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% //get the parameter => menu.jsp?id=5
    int id = Integer.parseInt(request.getParameter("id"));
    Menu m = new Menu();
    for (Menu me : currentUser.getMenuList()) { //go through the user's menus
        if (me.getId() == id) {   //search for the same id
            m = me;
            break; //stop if found
        }
    }
%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Recipe-hoarder</title>
</head>
<body>
<%@ include file="WEB-INF/header.jsp" %>
<main role="main">
    <div class="container">
        <h1 style="margin-bottom: 40px; margin-top: 30px" class="display-4"><%=m.getTitle()%></h1>

        <div class="d-flex flex-wrap justify-content-center">
            <c:forEach items="<%=m.getMenuRecipes()%>" var="recipe">
                <div class="card shadow-sm" style="width: 20rem; margin: 40px">
                    <div class="card-body">
                        <h5 class="card-title">${recipe.name}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${recipe.cathegory}</h6>
                        <p class="card-text">${recipe.description}</p>
                        <div class="d-flex justify-content-between">
                            <a href="recipe.jsp?id=${recipe.id}" style="align-self: center;" class="card-link">Go to
                                Recipe</a>
                            <form method="post" action="api/recipe-delete-from-menu">
                                <input hidden name="menuId" value="<%=m.getId()%>"></input>
                                <button name="id" value="${recipe.id}" style="margin-top: 17px;" class="btn btn-danger">Delete from Menu</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</main>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>
