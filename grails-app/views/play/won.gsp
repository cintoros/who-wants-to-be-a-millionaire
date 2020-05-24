<%--
  Created by IntelliJ IDEA.
  User: corra
  Date: 17.05.2020
  Time: 18:02
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Victory</title>

    <asset:stylesheet src="millionaire.css"/>
</head>

<body>

<div id="container" role="main">
    <div class="row">
        <div class="justify-content-center text-center">
            <h1 class="display-2">Congratulations<sec:ifLoggedIn> <sec:username/>!</sec:ifLoggedIn> You won and are now a Millionaire!</h1>

            <div class="img-hover" title="Play again!">
                <a href="/play">
                    <asset:image class="img-responsive img-rounded" alt="Millionaire Logo"
                                 src="millionaire/millionaire.png" height="250"
                                 width="250"/>
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
