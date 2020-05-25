/**
 * Toggles the correct answer and button to be displayed to the moderator
 * @param questionId the question id
 */
function toggleVisibility(questionId) {
    let correctAnswer = document.getElementById("correct-answer" + questionId);
    const token = 'list-group-item-success';

    correctAnswer.classList.toggle(token);

    let showHideButton = document.getElementById("show-hide-button" + questionId);
    if (showHideButton.innerHTML === "Show Answer") {
        showHideButton.innerHTML = "Hide Answer"
    } else {
        showHideButton.innerHTML = "Show Answer"
    }
}

let jokerUsed = 'false';
let answer = '';

function callControllerWithSelectedAnswer() {
    window.location = '/play?answer=' + answer + '&joker=' + jokerUsed
}

/**
 * Toggles the selected answer to be displayed and sets the answer field of this class
 *
 * Additionally it enables the confirm button,
 * changes its styling and its text to "Confirm".
 *
 *  @param elementId the html id of the tag
 */
function toggleSelectedAnswer(elementId) {
    const correct = "correct-answer";
    const wrong1 = "wrong-answer1";
    const wrong2 = "wrong-answer2";
    const wrong3 = "wrong-answer3";
    const highlight = 'list-group-item-primary';

    const confirmButton = document.getElementById("confirm-button");
    confirmButton.disabled = false;
    confirmButton.classList.remove("btn-secondary");
    confirmButton.classList.add("btn-success");
    confirmButton.innerHTML = "Confirm"

    document.getElementById(correct).classList.remove(highlight);

    if (document.getElementById(wrong1) !== null) {
        document.getElementById(wrong1).classList.remove(highlight);
    }

    if (document.getElementById(wrong2) !== null) {
        document.getElementById(wrong2).classList.remove(highlight);
    }

    if (document.getElementById(wrong3) !== null) {
        document.getElementById(wrong3).classList.remove(highlight);
    }

    let selectedAnswer = document.getElementById(elementId);
    selectedAnswer.classList.add(highlight);
    answer = selectedAnswer.innerText;
}

/**
 * Removes two wrong answers.
 * Used for the 50% joker.
 *
 * Sets jokerUser field to true.
 *
 * @param answer1 the answer to be removed
 * @param answer2 the answer to be removed
 */
function removeTwoWrongAnswers(answer1, answer2) {
    document.getElementById(answer1).remove();
    document.getElementById(answer2).remove();
    document.getElementById('joker').remove();

    jokerUsed = 'true'
}

/**
 * Function to clear selected correct and wrong answers for a Moderator.
 *
 * Renames Show/Hide Answer Button correctly.
 *
 * @param questionId the question id
 */
function clearQuestion(questionId) {
    const correct = "correct-answer" + (questionId + 1);
    const wrong1 = "wrong-answer" + (questionId + 1) + questionId;
    const wrong2 = "wrong-answer" + (questionId + 1) + (questionId + 1);
    const wrong3 = "wrong-answer" + (questionId + 1) + (questionId + 2);

    document.getElementById(correct).classList.remove('list-group-item-success');
    document.getElementById(wrong1).classList.remove('list-group-item-danger');
    document.getElementById(wrong2).classList.remove('list-group-item-danger');
    document.getElementById(wrong3).classList.remove('list-group-item-danger');

    let showHideButton = document.getElementById("show-hide-button" + (questionId + 1));
    if (showHideButton.innerHTML === "Hide Answer") {
        showHideButton.innerHTML = "Show Answer";
    }
}

function markAsWrongAnswer(questionId) {
    document.getElementById("wrong-answer" + questionId).classList.add('list-group-item-danger');
}

function markAsCorrectAnswer(questionId) {
    document.getElementById("correct-answer" + questionId).classList.add('list-group-item-success');
    let showHideButton = document.getElementById("show-hide-button" + (questionId + 1));
    // showHideButton.innerHTML = "Hide Answer";
}

/**
 * Shuffles all question answers (must be div-tags) within the specified question id
 * @param questionId the question id
 */
function shuffleQuestionAnswers(questionId) {
    shuffle(document.querySelectorAll('#shuffle' + questionId + '> div'));
}

/**
 * Shuffles all divs inside element id: shuffle
 */
function shuffleQuestion() {
    shuffle(document.querySelectorAll('#shuffle > div'));
}

/**
 * EXTERNAL: https://codepen.io/dimayakovlev/pen/VmxOYM
 */
function shuffle(elems) {
    allElems = (function () {
        var ret = [], l = elems.length;
        while (l--) {
            ret[ret.length] = elems[l];
        }
        return ret;
    })();

    var shuffled = (function () {
        var l = allElems.length, ret = [];
        while (l--) {
            var random = Math.floor(Math.random() * allElems.length),
                randEl = allElems[random].cloneNode(true);
            allElems.splice(random, 1);
            ret[ret.length] = randEl;
        }
        return ret;
    })(), l = elems.length;

    while (l--) {
        elems[l].parentNode.insertBefore(shuffled[l], elems[l].nextSibling);
        elems[l].parentNode.removeChild(elems[l]);
    }
}