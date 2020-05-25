package webec

import grails.gorm.transactions.Transactional

@Transactional
class PlayService {

    /**
     * Removes 2 wrong answers from a question
     * @param questionId the question id
     * @return question with 2 wrong answers (null-values)
     */
    def removeTwoWrongAnswersFromQuestion(Long questionId) {
        Question question = Question.findById(questionId)
        question.second = null
        question.third = null
        question
    }

    /**
     * Finds question by id.
     *
     * Method could be used for testing purposes.
     *
     * @param questionId the question id
     * @return the question or a default question
     */
    Question findQuestionOrDefault(Long questionId) {
        Question question = Question.findById(questionId)
        if(question == null) {
            new Question(correct: "A", questionText: "QQQ", second: "XXX", third: "YYY", fourth: "ZZZ")
        }
        else {
            question
        }
    }

}
