package webec

class PlayController {
    def questionService
    Game game
    Question lastQuestion

    /**
     * Will create a new controller instance per user browser session.
     * A different browser will have a different session and therefore
     * an independent game.
     */
    static scope = "session"


    /**
     * Handles the interactive 15 questions game.
     * @return the game entity to be displayed to the view.
     */
    def index() {
        String answer = params.get("answer")
        String joker = params.get("joker")

        if (answer == null || answer.isEmpty()) {
            game = newGame()
        } else {
            if(game == null || game.questions == null) {
                // start new game
                redirect(uri:'/')
                return
            }

            def currentQuestion = game?.questions[game.current]
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
        new Game(current: 0, questions: questionService.uniqueQuestionSet())
    }

    def moderator() {
        [questions: questionService.uniqueQuestionSet()]
    }
}

class Game {
    int current
    List<Question> questions
    boolean isJokerUsed
}
