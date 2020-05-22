<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Who wants to be a Millionaire</title>

    <asset:stylesheet src="millionaire.css"/>
</head>

<body>

<div id="container" role="main">
    <div class="row">
        <div class="justify-content-center text-center">
            <h1 class="display-2">Who wants to be a Millionaire?</h1>

            <div class="img-hover" title="Play the Game!">
                <a href="/play">
                    <asset:image class="img-responsive img-rounded" alt="Millionaire Logo"
                                 src="millionaire/millionaire.png" height="250px"
                                 width="250px"/>
                </a>
            </div>
            <sec:ifLoggedIn>
                <h1 class="display-4">Hello <sec:username/></h1>
            </sec:ifLoggedIn>

        </div>
    </div>
</div>

</body>
</html>
