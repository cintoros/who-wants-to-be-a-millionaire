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

}
