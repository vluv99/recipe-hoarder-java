<%@ page import="com.vluv.recipe_hoarder_core.model.Recipe" %>
<jsp:useBean id="currentUser" class="com.vluv.recipe_hoarder_core.model.User" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% //get the parameter => recipe.jsp?id=5
    int id = Integer.parseInt(request.getParameter("id"));
    Recipe rec = new Recipe();
    for (Recipe r : currentUser.getRecipeList()) { //go through the user's recipes
        if (r.getId() == id) {   //search for the same id
            rec = r;
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
    <div class="container d-flex justify-content-center">

        <div class="card border-dark mb-3" style="max-width: 60rem; margin-top: 40px">

            <div class="card-body text-dark">
                <div class="card-header bg-transparent border-dark" style="margin-bottom: 15px">
                    <h1 class="display-4 list-inline-item card-title">
                        <%=rec.getName()%>
                    </h1>
                    <small class="text-muted list-inline-item card-text">
                        <%=rec.getCathegory()%>
                    </small>
                </div>

                <dl class="row">
                    <dt class="col-sm-3">Description</dt>
                    <dd class="col-sm-9 font-italic"><%=rec.getDescription()%>
                    </dd>

                    <dt class="col-sm-3">Ingredients</dt>
                    <dd class="col-sm-9">
                        <ul>
                            <c:forEach items="<%=rec.getIngredients()%>" var="ingredients">
                                <li><c:out value="${ingredients.name_amount}"/></li>
                            </c:forEach>
                        </ul>
                    </dd>

                    <dt class="col-sm-3">Directions</dt>
                    <dd class="col-sm-9">
                        <ol>
                            <c:forEach items="<%=rec.getDirections()%>" var="directions">
                                <li><c:out value="${directions.direction}"/></li>
                            </c:forEach>
                        </ol>
                    </dd>
                </dl>
            </div>
            <div class="card-footer bg-transparent border-dark d-flex justify-content-between">
                <form action="api/recipe-ingredients-to-shopping-list" method="post">
                <button name="id" value="<%=rec.getId()%>" class="list-inline-item btn btn-secondary">Add Ingredients to Shopping List</button>
                </form>

                <!--
                <%
                    if (true) { //condition if the recipe is in a menu or not
                %>
                <button type="button" class="btn btn-warning">Back to Menu</button>
                <% } %>-->

                <form action="api/recipe-delete" method="post">
                    <button name="id" value="<%=rec.getId()%>" class="list-inline-item btn btn-danger">Delete Recipe</button>
                </form>
            </div>
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
