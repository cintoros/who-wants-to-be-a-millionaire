<%--
  Created by IntelliJ IDEA.
  User: corra
  Date: 16.05.2020
  Time: 10:31
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <asset:javascript src="utility.js"/>
    <title>Be the Moderator</title>
</head>

<body>

<h1 class="display-3">Be the moderator!</h1>

<div class="card">
    <div class="card-body">
        %{--
          Developer's note:
          In "Be the Moderator" mode the correct answers are visible in the HTML DOM with F12.
          Purpose: This is efficient as everything is handled on the client.
          There is no need to request the correct answer from the server in this moderator setting.
        --}%
        <g:each status="i" var="question" in="${questions}">
            <h1 class="card-text">Question ${i + 1}: ${question.questionText}</h1>

            <div id="shuffle${i + 1}" class="mt-3 card-text list-group">
                <div id="correct-answer${i + 1}" onclick="markAsCorrectAnswer(${i+1})"
                     class="list-group-item list-group-item-action">${question.correct}</div>

                <div id="wrong-answer${i + 1}${i}" onclick="markAsWrongAnswer(${i+1}${i})"
                     class="list-group-item list-group-item-action">${question.second}</div>

                <div id="wrong-answer${i + 1}${i + 1}" onclick="markAsWrongAnswer(${i+1}${i+1})"
                     class="list-group-item list-group-item-action">${question.third}</div>

                <div id="wrong-answer${i + 1}${i + 2}" onclick="markAsWrongAnswer(${i+1}${i+2})"
                     class="list-group-item list-group-item-action">${question.fourth}</div>
            </div>

            <button onclick="toggleVisibility(${i+1})" id="show-hide-button${i + 1}" class="mt-3 btn-primary">
                Show Answer
            </button>
            <button onclick="clearQuestion(${i})" class="btn-secondary">Clear Question</button>
            <br/>
            <br/>
            <script>
                shuffleQuestionAnswers(${i+1})
            </script>
        </g:each>
    </div>
</div>

</body>
</html>