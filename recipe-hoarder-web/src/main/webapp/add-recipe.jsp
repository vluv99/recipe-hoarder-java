<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
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

        <h3 style="margin-top: 30px" class="display-4">Add Recipe from URL</h3>
        <form action="/api/recipe" method="post">
            <div class="form-row">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Recipe's URL"
                           aria-label="https://www.delish.com/cooking/recipe-ideas/recipes/a55501/best-goulash-recipe/"
                           aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="button-addon2">Add Recipe from URL
                        </button>
                    </div>
                </div>
            </div>
        </form>

        <br>
        <div role="separator"></div>

        <h3 class="display-4">Add Recipe Manually</h3>
        <form action="/api/recipe" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="name">Name</label>
                    <input name="name" type="text" class="form-control" id="name" placeholder="Goulash">
                </div>
                <div class="form-group col-md-6 ">
                    <label for="cathegory">Cathegory</label>
                    <select name="cathegory" class="form-control" id="cathegory">
                        <option selected>Choose...</option>
                        <option value="1">Appetizers, Beverages</option>
                        <option value="2">Soups, Salads</option>
                        <option value="3">Main Dishes</option>
                        <option value="4">Breads, Rolls</option>
                        <option value="5">Desserts</option>
                        <option value="6">Miscellaneous</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea name="description" class="form-control" id="description" rows="1"
                          placeholder="This recipe is great for..."></textarea>
            </div>

            <div class="form-group">
                <label for="ingredients">Ingredients</label>
                <textarea name="ingredients" class="form-control" id="ingredients" rows="5"
                          placeholder="500 dkg groung beef &#13;&#10;->write each ingredient in a new line!"></textarea>
            </div>
            <div class="form-group">
                <label for="directions">Directions</label>
                <textarea name="directions" class="form-control" id="directions" rows="5"
                          placeholder="Cut the onion to.. &#13;&#10;->write each step in a new line!"></textarea>
            </div>
            <button id="submit_button" type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
</main>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
