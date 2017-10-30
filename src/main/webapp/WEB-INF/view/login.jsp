<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://v4-alpha.getbootstrap.com/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="http://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://v4-alpha.getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
	<script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://v4-alpha.getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </head>

  <body>

    <div class="container">
    <div class="row justify-content-center h-100 text-center">
      <div class="col-8 align-self-center">
        <form class="form-signin" method="post" action="/login">
          <h2 class="form-signin-heading">Please sign in</h2>
          <label for="username" class="sr-only">Email address</label>
          <input name="username" type="text" id="username" class="form-control" placeholder="Email address" required="true" autofocus="true">
          <label for="password" class="sr-only">Password</label>
          <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required="true">
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <div class="checkbox">
            <label>
              <input type="checkbox" value="remember-me"> Remember me
            </label>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
          <a id="sign-up" class="btn btn-lg btn-primary btn-block" role="button" href="/registration">Register</a>
        </form>
        
      </div>
    </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->


  </body>
</html>
