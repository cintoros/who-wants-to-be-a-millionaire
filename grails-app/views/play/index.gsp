<%--
  Created by IntelliJ IDEA.
  User: corra
  Date: 13.05.2020
  Time: 10:39
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <asset:javascript src="utility.js"/>
    <title>Play as Player</title>
</head>

<body>
<h1 class="display-3">Play the game!</h1>
<div class="col">
    <div id="shuffle">
        <h3>${game.questions.get(game.current).questionText}</h3>
        <div id="correct-answer" class="card list-group-item-action col"
             onclick="toggleSelectedAnswer('correct-answer')">
            <div class="card-body">
                <h5 class="card-title">${game.questions.get(this.game.current).correct}</h5>
            </div>
        </div>
        <div id="wrong-answer1" class="card list-group-item-action col" onclick="toggleSelectedAnswer('wrong-answer1')">
            <div class="card-body">
                <h5 class="card-title">${game.questions.get(game.current).second}</h5>
            </div>
        </div>
        <div id="wrong-answer2" class="card list-group-item-action col" onclick="toggleSelectedAnswer('wrong-answer2')">
            <div class="card-body">
                <h5 class="card-title">${game.questions.get(game.current).third}</h5>
            </div>
        </div>
        <div id="wrong-answer3" class="card list-group-item-action col" onclick="toggleSelectedAnswer('wrong-answer3')">
            <div class="card-body">
                <h5 class="card-title">${game.questions.get(game.current).fourth}</h5>
            </div>
        </div>
    </div>

    <div class="card list-group-item-action">
        <button type="button" class="btn btn-success" onclick="callControllerWithSelectedAnswer()">Confirm</button>
    </div>

    <script>
        shuffleQuestion()
    </script>
</div>
</body>
</html>