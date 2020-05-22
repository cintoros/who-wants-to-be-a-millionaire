<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Who wants to be a Millionaire"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="millionaire.css"/>
    <asset:javascript src="application.js"/>

    <g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Who Wants to Be a Millionaire?</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/play">Play    <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/play/moderator">Be the Moderator</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/question">Question Editor</a>
            </li>

            <sec:ifLoggedIn>
                <li class="nav-item">
                    <g:link class="nav-link" controller="logout">Logout</g:link>
                </li>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <li class="nav-item">
                    <g:link class="nav-link" controller="login">Login</g:link>
                </li>
            </sec:ifNotLoggedIn>
        </ul>
    </div>
</nav>

<main class="container" role="main">
    <g:layoutBody/>
</main>
</body>
</html>
