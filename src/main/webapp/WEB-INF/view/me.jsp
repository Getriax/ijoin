<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://v4-alpha.getbootstrap.com/favicon.ico">
<link href="profile.css" rel="stylesheet" />
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
				href="/${user.getUsername()}">${user.getUsername()}</a> <a class="nav-link" href="#">Find</a>
			<a class="nav-link" href="/${user.getUsername()}/more">Settings</a> </nav>
		</div>
	</div>

	<div class="blog-header"></div>

	<div class="container">

		<div class="row">
			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>${user.getUsername()}</h4>
					<p>
						<c:if test="${not empty user.getAbout()}">
							${user.getAbout()}
						</c:if>
					</p>
				</div>
			</div>
			<div class="col-sm-8 blog-main h-100">

				<div class="blog-post h-100">
					<p>This blog post shows a few different types of content that's
						supported and styled with Bootstrap. Basic typography, images, and
						code are all supported.</p>
					<hr>
					<p>
						Cum sociis natoque penatibus et magnis <a href="#">dis
							parturient montes</a>, nascetur ridiculus mus. Aenean eu leo quam.
						Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed
						posuere consectetur est at lobortis. Cras mattis consectetur purus
						sit amet fermentum.
					</p>
					<blockquote>
						<p>
							Curabitur blandit tempus porttitor. <strong>Nullam quis
								risus eget urna mollis</strong> ornare vel eu leo. Nullam id dolor id
							nibh ultricies vehicula ut id elit.
						</p>
					</blockquote>
					<p>
						Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras
						mattis consectetur purus sit amet fermentum. Aenean lacinia
						bibendum nulla sed consectetur.
					</p>
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


</body>

</html>