<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Delectable Doughnuts</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        body {
            background-image:
                url('image/dnut_back.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
</head>

<body>

    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="logout.chan"> Delectable D<img src="image/smalld.png" height="45"
                width="45">ughnuts
        </a>
        <a class="navbar-brand" href="logout.chan">Logout</a>
    </nav>
    <!-- template -->







    <br>
    <br>
    <br>
    <div style="color: white; margin: 30px;">
        <div class="card text-white bg-dark mb-3 mx-auto align-middle rounded" style="width: 1000px;">
            <div class="card-body">
                <h1 style="text-align: center; margin: 25px;">Aprove or Deny Reimbursements</h1>
            </div>
        </div>


        <!-- put things here -->

 		${requestScope["allthethings"]}
 

        <!--  -->


 <!--        <div class="card text-white bg-dark mb-3 mx-auto align-middle rounded" style="width: 1000px;">
            <div class="card-body">
                <div class="container">
                    <div class="row justify-content-md-center">
                        <div class="col-3"></div>
                        <div class="col-6">
                            <button type="submit" value="Login" class="btn btn-lg btn-block"
                                style="background-color: rgb(231, 120, 213);">
                                <b>Submit</b>
                            </button>
                        </div>
                        <div class="col-3"></div>
                    </div>
                </div>
            </div>
        </div> -->


    </div>






    <!-- template -->
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