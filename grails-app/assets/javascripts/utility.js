/**
 * Toggles the correct answer and button to be displayed to the moderator
 * @param questionId the question id
 */
function toggleVisibility(questionId) {
    let x = document.getElementById("correct-answer" + questionId);
    x.classList.toggle('list-group-item-success');

    let y = document.getElementById("show-hide-button" + questionId);
    if(y.innerHTML === "Show Answer") {
        y.innerHTML = "Hide Answer"
    }
    else {
        y.innerHTML = "Show Answer"
    }
}

/**
 * Function to clear selected correct and wrong answers for a Moderator
 * @param questionId the question id
 */
function clearQuestion(questionId) {
    const correct = "correct-answer" + (questionId+1);
    const wrong1 = "wrong-answer" + (questionId+1)  + questionId;
    const wrong2 = "wrong-answer" + (questionId+1)  + (questionId+1);
    const wrong3 = "wrong-answer" + (questionId+1)  + (questionId+2);

    document.getElementById(correct).classList.remove('list-group-item-success');
    document.getElementById(wrong1).classList.remove('list-group-item-danger');
    document.getElementById(wrong2).classList.remove('list-group-item-danger');
    document.getElementById(wrong3).classList.remove('list-group-item-danger');
}

function markAsWrongAnswer(questionId) {
    document.getElementById("wrong-answer" + questionId).classList.add('list-group-item-danger');
}

function markAsCorrectAnswer(questionId) {
    document.getElementById("correct-answer" + questionId).classList.add('list-group-item-success');
}

/**
 * Shuffles all question answers (must be a-tags) within the specified question id
 * @param questionId the question id
 */
function shuffleQuestions(questionId) {
    shuffle(document.querySelectorAll('#shuffle' + questionId + '> a'));
}