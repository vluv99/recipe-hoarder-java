<%@ page import="com.vluv.recipe_hoarder_core.model.Recipe" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="currentUser" class="com.vluv.recipe_hoarder_core.model.User" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<Recipe> searchList = new ArrayList<Recipe>();
    String str = request.getParameter("search");
    String str_type = request.getParameter("type_search");
    if (str != null){
        for (Recipe r : currentUser.getRecipeList()) {
            if (r.getName().toLowerCase().contains(str.toLowerCase())){
                searchList.add(r);
            }
        }
        request.removeAttribute("search");
    }else if (str_type != null) {
        for (Recipe r : currentUser.getRecipeList()) {
            if(str_type.equals(r.getCathegory())){
                searchList.add(r);
            }
        }
        request.removeAttribute("type_search");
    }else {
        searchList = currentUser.getRecipeList();
    }

    pageContext.setAttribute("recipes", searchList);
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
        <h1 style="margin-bottom: 40px; margin-top: 30px" class="display-4 list-inline-item">Recipes</h1>

        <form>
            <div style="margin-bottom: 30px" class="input-group">
                <input name="search" type="text" class="form-control" aria-label="Text input with segmented dropdown button">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-outline-secondary">Search</button>
                    <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="sr-only">Seach Cathegory</span>
                    </button>
                    <div class="dropdown-menu">
                        <button name="type_search" type="submit" value="Appetizers, Beverages" class="btn btn-outline-secondary">Appetizers, Beverages</button>
                        <button name="type_search" type="submit" value="Soups, Salads" class="btn btn-outline-secondary">Soups, Salads</button>
                        <button name="type_search" type="submit" value="Main Dishes" class="btn btn-outline-secondary">Main Dishes</button>
                        <button name="type_search" type="submit" value="Breads, Rolls" class="btn btn-outline-secondary">Breads, Rolls</button>
                        <button name="type_search" type="submit" value="Desserts" class="btn btn-outline-secondary">Desserts</button>
                        <div role="separator" class="dropdown-divider"></div>
                        <button name="type_search" type="submit" value="Miscellaneous" class="btn btn-outline-secondary">Miscellaneous</button>
                    </div>
                </div>
            </div>
        </form>

        <div class="d-flex flex-wrap justify-content-center">
<!--currentUser.recipeList-->
            <c:forEach items="${recipes}" var="recipe">
                <div class="card shadow-sm" style="width: 18rem; margin: 25px">
                    <div class="card-body">
                        <h5 class="card-title">
                            <c:out value="${recipe.name}"/>
                        </h5>
                        <h6 class="card-subtitle mb-2 text-muted"><c:out value="${recipe.cathegory}"/></h6>
                        <p class="card-text"><c:out value="${recipe.description}"/></p>
                        <div class="d-flex justify-content-between">
                            <a href="recipe.jsp?id=${recipe.id}" style="margin-top: 8px;" class="card-link list-inline-item">Go to Recipe</a>
                            <form action="api/add-recipe-to-menu" method="post" class="list-inline-item">
                                <div class="dropdown align-items-end">
                                        <button class="btn btn-secondary dropdown-toggle" type="button"
                                                id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
                                                aria-expanded="false">
                                            Add to Menu
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                            <c:forEach items="${currentUser.menuList}" var="menu">
                                                <input hidden name="recipeId" value="${recipe.id}">
                                                <button name="menuId" value="${menu.id}" class="dropdown-item" type="submit">${menu.title}</button>
                                            </c:forEach>
                                        </div>
                                    </div>
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
