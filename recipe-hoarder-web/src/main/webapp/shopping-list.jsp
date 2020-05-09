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
        <h1 style="margin-bottom: 40px; margin-top: 30px" class="display-4 list-inline-item">Shopping List</h1>

        <form action="api/shoppingList-add" method="post">
            <div class="form-row">
                <div class="input-group mb-3">
                    <input name="list-item" type="text" class="form-control" placeholder="1 kg potato"
                           aria-label="Recipient's username" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit" id="button-list-item">Add Ingredient to
                            List
                        </button>
                    </div>
                </div>
            </div>
        </form>

        <br>

        <div class="d-flex justify-content-center">
            <div class="card" style="max-width: 400px;">
                <div class="card-body">

                    <ul class="list-group list-group-flush">
                        <form action="api/shoppingList-delete" method="post">
                        <c:forEach items="${currentUser.shoppingList}" var="item">
                            <li class="list-group-item d-flex justify-content-between">
                                <div style="margin-right: 20px;align-self: center;"><c:out value="${item.name_amount}"/></div>
                                <button name="id" value="${item.id}" class="btn btn-danger">
                                    Delete
                                </button>
                            </li>
                        </c:forEach>
                        </form>
                    </ul>
                </div>
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
