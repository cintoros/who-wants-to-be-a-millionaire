<%--
  Created by IntelliJ IDEA.
  User: corra
  Date: 21.05.2020
  Time: 14:23
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Cheat</title>

    <asset:stylesheet src="millionaire.css"/>
</head>

<body>

<div id="container" role="main">
    <div class="row">
        <div class="justify-content-center text-center">
            <h1 class="display-2">
                Anti Cheat Detection Triggered! Your run was aborted.
            </h1>

            <div class="img-hover mt-5" title="Play again without cheating!">
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
