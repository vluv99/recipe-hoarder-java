<jsp:useBean id="currentUser" class="com.vluv.recipe_hoarder_core.model.User" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <ul class="list-inline">
            <h1 style="margin-bottom: 40px; margin-top: 30px" class="display-4 list-inline-item">Menus</h1>

            <form action="api/menu" method="post">
                <div class="form-row">
                    <div class="input-group mb-3">
                        <input name="title" type="text" class="form-control" placeholder="Menu's name"
                               aria-label="Recipient's username" aria-describedby="button-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Create New Menu
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </ul>


        <div class="d-flex flex-wrap justify-content-center">

            <c:forEach items="${currentUser.menuList}" var="menu">
                <div class="card shadow-sm" style="width: 18rem; margin: 25px">
                    <div class="card-body">
                        <h5 class="card-title"><c:out value="${menu.title}"/></h5>
                        <h6 class="card-subtitle mb-2 text-muted">recipe no.: ${menu.menuRecipes.size()} </h6>
                        <div class="d-flex justify-content-between">
                            <a href="menu.jsp?id=${menu.id}" style="align-self: center;" class="card-link">Go to
                                Menu</a>
                            <form action="api/menu-delete" method="post">
                                <button name="id" value="${menu.id}" style="margin-top: 17px;" class="btn btn-danger">Delete Menu</button>
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
