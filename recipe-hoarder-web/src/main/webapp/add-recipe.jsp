<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>

<div class="container">
    <h1>Add recipe</h1>
    <form action="/">
        <div class="form-group">
            <label for="name">Name</label>
            <input name="name" type="text" class="form-control" id="name" placeholder="Goulash">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea name="description" class="form-control" id="description" rows="3"
                      placeholder="This recipe is great for..."></textarea>
        </div>
        <div class="form-group">
            <label for="cathegory">Cathegory</label>
            <select name="cathegory" class="form-control" id="cathegory">
                <option value="1">Appetizers, Beverages</option>
                <option value="2">Soups, Salads</option>
                <option value="3">Main Dishes</option>
                <option value="4">Breads, Rolls</option>
                <option value="5">Desserts</option>
                <option value="6">Miscellaneous</option>
            </select>
        </div>
        <div class="form-group">
            <label for="ingredients">Ingredients</label>
            <textarea name="ingredients" class="form-control" id="ingredients" rows="3"
                      placeholder="500 dkg groung beef &#13;&#10; ->write each ingredient in a new line!}"></textarea>
        </div>
        <div class="form-group">
            <label for="directions">Directions</label>
            <textarea name="directions" class="form-control" id="directions" rows="3"
                      placeholder="Cut the onion to.. &#13;&#10; ->write each step in a new line!}"></textarea>
        </div>
        <button id="submit_button" type="submit" class="btn btn-primary">Add</button>
    </form>
</div>


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