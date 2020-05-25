package webec

class QuestionController {

    static scaffold = Question
    def questionService

    /**
     * Returns all questions.
     * @return the question list to be displayed to the view.
     */
    def index() {
        [questions: questionService.all()]
    }
}
