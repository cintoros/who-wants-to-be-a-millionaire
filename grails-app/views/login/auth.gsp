<%--
  Created by IntelliJ IDEA.
  User: corra
  Date: 21.05.2020
  Time: 15:17
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="${gspLayout ?: 'main'}"/>
    <title><g:message code='springSecurity.login.title'/></title>
</head>

<body>

<div class="form-group">
    <div class="container">
        <h1>
            <g:message code='springSecurity.login.header'/>
        </h1>

        <g:if test='${flash.message}'>
            <div class="login_message">${flash.message}</div>
        </g:if>

        <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform"
              autocomplete="off">

            <div class="form-group">
                <label for="username"><g:message code='springSecurity.login.username.label'/></label>
                <input type="text" class="form-control" name="${usernameParameter ?: 'username'}" id="username"
                       aria-describedby="username" placeholder="Enter username">
            </div>

            <div class="form-group">
                <label for="password"><g:message code='springSecurity.login.password.label'/></label>
                <input type="password" name="${passwordParameter ?: 'password'}" class="form-control" id="password"
                       placeholder="Password">
            </div>

            <div class="form-group">
                <input type="checkbox" name="${rememberMeParameter ?: 'remember-me'}" class="chk"
                       name="${rememberMeParameter ?: 'remember-me'}" id="remember_me"
                       <g:if test='${hasCookie}'>checked="checked"</g:if>/>
                <label for="remember_me"><g:message code='springSecurity.login.remember.me.label'/></label>
            </div>

            <div>
                <input type="submit" class="btn btn-primary" id="submit"
                       value="${message(code: 'springSecurity.login.button')}"/>
            </div>
        </form>
    </div>
</div>
<script>
    (function () {
        document.forms['loginForm'].elements['${usernameParameter ?: 'username'}'].focus();
    })();
</script>
</body>
</html>
