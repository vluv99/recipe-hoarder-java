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

<main role="main" style="margin-top: 100px">
    <div class="container">
        <h1>Register</h1>
        <form method="post" action="register">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="validationServerUsername">Email</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupPrepend3">@</span>
                        </div>
                        <input name="mail" type="email" class="form-control is-invalid" id="validationServerUsername"
                               aria-describedby="inputGroupPrepend3" required>
                        <%
                            if (true) //TODO validations
                        %>
                        <div class="invalid-feedback">
                            Please write in your unique email address.
                        </div>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input name="password" type="password" class="form-control is-valid" id="inputPassword4">
                    <div class="invalid-feedback">
                        Please choose a password.
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="inputName">Name</label>
                <input name="name" type="text" class="form-control is-valid" id="inputName" placeholder="Gipsz Jakab">
                <div class="invalid-feedback">
                    Please give your name.
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input name="address" type="text" class="form-control is-valid" id="inputAddress"
                       placeholder="6724 Szeged, Szentharomsag u. 3.">
                <div class="invalid-feedback">
                    Please provide a valid home address.
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Register</button>
        </form>
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
