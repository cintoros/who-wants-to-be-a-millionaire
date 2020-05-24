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
    <title>Lost</title>

    <asset:stylesheet src="millionaire.css"/>
</head>

<body>

<div id="container" role="main">
    <div class="row">
        <div class="justify-content-center text-center">
            <h1 class="display-2">
                Unfortunately, you lost.
            </h1>

            <div class="m-5">
                <h2>The answer to: ${game.questions[game.current].questionText}</h2>
                <h3>Would have been: ${game.questions[game.current].correct}</h3>
            </div>

            <div class="img-hover mt-5" title="Play again!">
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
