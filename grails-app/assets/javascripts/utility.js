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
        showHideButton.innerHTML = "Hide Answer";
    } else if (showHideButton.innerHTML === "Hide Answer") {
        showHideButton.innerHTML = "Show Answer";
    }
}

let answer = '';

function callControllerWithSelectedAnswer() {
    window.location = '/play?answer=' + answer
}

function callControllerWithJoker() {
    window.location = '/play?joker=true'
}

/**
 * Removes a specified class from a specified element
 * @param elementId the element id
 * @param classToRemove the class to remove
 */
function removeClass(elementId, classToRemove) {
    if (document.getElementById(elementId) !== null) {
        document.getElementById(elementId).classList.remove(classToRemove);
    }
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
    const answer1 = "answer1";
    const answer2 = "answer2";
    const answer3 = "answer3";
    const answer4 = "answer4";
    const highlight = 'list-group-item-primary';

    const confirmButton = document.getElementById("confirm-button");
    confirmButton.disabled = false;
    confirmButton.classList.remove("btn-secondary");
    confirmButton.classList.add("btn-success");
    confirmButton.innerHTML = "Confirm"

    removeClass(answer1, highlight);
    removeClass(answer2, highlight);
    removeClass(answer3, highlight);
    removeClass(answer4, highlight);

    let selectedAnswer = document.getElementById(elementId);
    selectedAnswer.classList.add(highlight);
    answer = selectedAnswer.innerText;
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

    removeClass(correct, 'list-group-item-success')
    removeClass(wrong1, 'list-group-item-danger')
    removeClass(wrong2, 'list-group-item-danger')
    removeClass(wrong3, 'list-group-item-danger')
    // document.getElementById(correct).classList.remove('list-group-item-success');
    // document.getElementById(wrong1).classList.remove('list-group-item-danger');
    // document.getElementById(wrong2).classList.remove('list-group-item-danger');
    // document.getElementById(wrong3).classList.remove('list-group-item-danger');

    let showHideButton = document.getElementById("show-hide-button" + (questionId + 1));
    if (showHideButton.innerHTML === "Hide Answer") {
        showHideButton.innerHTML = "Show Answer";
    }
}

function markAsWrongAnswer(questionId) {
    document.getElementById("wrong-answer" + questionId).classList.add('list-group-item-danger');
}

/**
 * Highlight the correct Answer for the moderator
 * @param questionId the question id to highlight
 */
function markAsCorrectAnswer(questionId) {
    document.getElementById("correct-answer" + questionId).classList.add('list-group-item-success');
    let showHideButton = document.getElementById("show-hide-button" + questionId);
    showHideButton.innerHTML = "Hide Answer"
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