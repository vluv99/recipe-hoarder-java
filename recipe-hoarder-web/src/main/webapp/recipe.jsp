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
                    <h1 class="display-4 list-inline-item card-title">Title</h1>
                    <small class="text-muted list-inline-item card-text">cathegory</small>
                </div>

                <dl class="row">
                    <dt class="col-sm-3">Description</dt>
                    <dd class="col-sm-9"><% %> hhhhhhhhh</dd>

                    <dt class="col-sm-3">Ingredients</dt>
                    <dd class="col-sm-9">
                        <ul>
                            <li>1 kg ez</li>
                            <li>1 kg az</li>
                            <li>3 kg emaz</li>
                            <li>4 kg jddd</li>
                        </ul>
                    </dd>

                    <dt class="col-sm-3">Directions</dt>
                    <dd class="col-sm-9">
                        <ol>
                            <li>igy</li>
                            <li>zgy</li>
                            <li>amugy</li>
                            <li>emigy</li>
                        </ol>
                    </dd>
                </dl>
            </div>
            <div class="card-footer bg-transparent border-dark d-flex justify-content-between">
                <button type="button" class="list-inline-item btn btn-secondary">Add Ingredients to Shopping List
                </button>

                <button type="button" class="btn btn-warning">Back to Menu</button>

                <button type="button" class="list-inline-item btn btn-danger">Delete Recipe</button>
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
