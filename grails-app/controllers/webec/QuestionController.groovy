package webec

class QuestionController {

    static scaffold = Question
    def questionService

    def index() {
        [questions: questionService.all()]
    }
}
