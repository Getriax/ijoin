<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="Nikodem">
<link rel="icon" href="http://v4-alpha.getbootstrap.com/favicon.ico">
<link href='<c:url value="/static/css/main.css"/>' rel="stylesheet" />
<title>${username}</title>

<!-- Bootstrap core CSS -->
<link href="http://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="http://v4-alpha.getbootstrap.com/examples/blog/blog.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="http://v4-alpha.getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
</head>

<body>

	<div class="blog-masthead">
		<div class="container">
			<nav class="nav blog-nav"> <a class="nav-link active"
				href="/${user.getUsername()}">${username}</a> <a class="nav-link"
				href="#">Find</a> <a class="nav-link" href="{}">Settings</a> </nav>
		</div>
	</div>
	<div id="my_data">
	<div class="blog-header">
		<div class="row justify-content-center">
			<div class="col-5 align-self-center">
			<button v-on:click="updateUser()" class="btn btn-primary btn-block">Zapisz</button>
			</div>
			<div class="col-5 align-self-center">
			<button class="btn btn-warning btn-block" v-on:click="redirect(${user.getUsername()})">Cofnij</button>
			</div>
		</div>
	</div>

	<div class="container">

		<input type="hidden" id="uname" value="${user.getUsername()}" /> <input
			type="hidden" id="csrf" value="${_csrf.token}" />
		<div class="row">
			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>About</h4>
					<p>{{details['about']}}</p>
					<h4>Preferences</h4>

					<div class="row no-gutters">
						<div class="col-4" v-for="(pref, inx) in prefs">
							<button
								class="prefs-del btn-warning mt-1">{{pref}}</button>
						</div>						
					</div>
				</div>
			</div>
			<div class="col-sm-8 blog-main h-100">

				<div class="blog-post h-100">

					<h3 class="form-signin-heading">Preferences</h3>
					<input type="text" id="pref" class="form-control"
						placeholder="Java C++ C# Ruby..." required="false"
						autofocus="true" v-on:keyup.space="addPreference()" />

					<h3 class="form-signin-heading">About</h3>
					<textarea id="pref" id="about" class="form-control"
						placeholder="About" required="false" autofocus="true"
						v-model="details['about']" rows="6" maxlength="200"> </textarea>

					<h3 class="form-signin-heading">Location</h3>
					<input type="text" id="pref" class="form-control"
						placeholder="Location" required="false" autofocus="true"
						v-model="details['location']" id="location"/>

				</div>


			</div>
			<!-- /.blog-post -->


		</div>
		<!-- /.blog-main -->

	</div>
	<!-- /.row -->
	</div>
	<!-- /.container -->
	
	<footer class="blog-footer mt-2">
	<p>
		Blog template built for <a href="http://getbootstrap.com">Bootstrap</a>
		by <a href="https://twitter.com/mdo">@mdo</a>.
	</p>
	<p>
		<a href="#">Back to top</a>
	</p>
	</footer>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="http://v4-alpha.getbootstrap.com/assets/js/vendor/jquery.min.js"></script>
	')
	</script>
	<script src="http://v4-alpha.getbootstrap.com/dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="http://v4-alpha.getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
	<script src="https://unpkg.com/vue"></script>
	<script src="https://unpkg.com/vue-resource@1.3.4"></script>
	<script src='<c:url value="/static/js/some.js"/>'
		type="text/javascript"></script>

</body>
</html>
