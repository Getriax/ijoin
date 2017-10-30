<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://v4-alpha.getbootstrap.com/favicon.ico">

    <title>Register</title>
	
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
      <div class="row justify-content-center text-center h-100">
          <div class="col-5 align-self-center">
            <form:form method="POST" modelAttribute="userForm" class="form">
              <h2 class="form-signin-heading">Sign up</h2>
              <spring:bind path="username">
            <div ${status.error ? 'has-error' : ''}>
            <form:input path="username" type="text" id="username" class="form-control mt-1" placeholder="Nick" required="true" autofocus="true"/>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="email">
       		<div ${status.error ? 'hase-error' : '' }>
       		      <form:input path="email" type="email" id="email" class="form-control mt-1" placeholder="Email address" required="true" autofocus="true"/>
       				<form:errors path="email"></form:errors>
       		</div> 
        </spring:bind>      
        <spring:bind path="password">
       		<div ${status.error ? 'hase-error' : '' }>
       		      <form:input path="password" type="password" id="password" class="form-control mt-1" placeholder="Password" required="true" autofocus="true"/>
       				<form:errors path="password"></form:errors>
       		</div> 
        </spring:bind>
        <spring:bind path="confirmPassword">
       		<div ${status.error ? 'hase-error' : '' }>
       		      <form:input path="confirmPassword" type="password" id="confirmPassword" class="form-control mt-1" placeholder="Confirm password" required="true" autofocus="true"/>
       				<form:errors path="confirmPassword"></form:errors>
       		</div> 
        </spring:bind>
        <form:hidden path="preferences"/>
              <button class="btn btn-lg btn-primary btn-block mt-2" type="submit">Sign up</button>      
        </form:form>
          </div>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->


  </body>
</html>
