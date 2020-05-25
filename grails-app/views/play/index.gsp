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

<div class="col">
    <div id="shuffle">
        <h1 class="display-4">Play the game!</h1>

        <h1>${game.current + 1}. Question: ${game.questions.get(game.current).questionText}</h1>

        <div id="correct-answer" class="card list-group-item-action col"
             onclick="toggleSelectedAnswer('correct-answer')">
            <div class="card-body">
                <h5 class="card-title">${game.questions.get(this.game.current).correct}</h5>
            </div>
        </div>

        <g:if test="${game.questions.get(game.current).second != null}">
            <div id="wrong-answer1" class="card list-group-item-action col"
                 onclick="toggleSelectedAnswer('wrong-answer1')">
                <div class="card-body">
                    <h5 class="card-title">${game.questions.get(game.current).second}</h5>
                </div>
            </div>
        </g:if>

        <g:if test="${game.questions.get(game.current).third != null}">
            <div id="wrong-answer2" class="card list-group-item-action col"
                 onclick="toggleSelectedAnswer('wrong-answer2')">
                <div class="card-body">
                    <h5 class="card-title">${game.questions.get(game.current).third}</h5>
                </div>
            </div>
        </g:if>

        <div id="wrong-answer3" class="card list-group-item-action col" onclick="toggleSelectedAnswer('wrong-answer3')">
            <div class="card-body">
                <h5 class="card-title">${game.questions.get(game.current).fourth}</h5>
            </div>
        </div>
    </div>


    <div class="card list-group-item-action">
        <g:if test="${!game.isJokerUsed}">
            <button id="joker" type="button" class="btn btn-warning"
                    onclick="callControllerWithJoker();">50/50 Joker</button>
        </g:if>
        <button disabled="disabled" id="confirm-button" type="button" class="btn btn-secondary"
                onclick="callControllerWithSelectedAnswer()">Click on an Answer</button>
    </div>

    <script>
        shuffleQuestion()
    </script>
</div>
</body>
</html>