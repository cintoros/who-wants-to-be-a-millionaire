package webec

class PlayController {
    def playService //FIXME use
    def questionService
    Game game
    Question lastQuestion


    def index() {
        String answer = params.get("answer")
        String joker = params.get("joker")

        if (answer == null || answer.isEmpty()) {
            game = newGame()
        } else {
            def currentQuestion = game.questions[game.current]
            if (currentQuestion == null || currentQuestion.correct == null || currentQuestion?.id == lastQuestion?.id) {
                // user cheated by pressing back button!
                render(view: 'cheat')
            } else {
                // won, lost logic
                def correct = currentQuestion.correct
                if (!game.isJokerUsed && joker == "true") {
                    game.isJokerUsed = true
                }

                if (answer == correct) {
                    // given answer was correct
                    game.current++ // go to next question
                    if (game.current == game.questions.size()) { // detect victory
                        render(view: 'won')
                    }
                } else {
                    // given answer was incorrect
                    render(view: 'lost', model: [game: game])
                }
                lastQuestion = currentQuestion
            }
        }
        [game: game]
    }

    private Game newGame() {
        // FIXME change  15
        new Game(current: 0, questions: questionService.uniqueQuestionSet(3), isFinished: false)
    }

    def moderator() {
        [questions: questionService.uniqueQuestionSet()]
    }


}

class Game {
    int current
    List<Question> questions
    boolean isFinished
    boolean isJokerUsed
}
