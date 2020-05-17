package webec

import grails.gorm.transactions.Transactional

@Transactional
class QuestionService {

    /**
     * Generates a random set of unique questions by the specified <code>size</code>
     *
     * If there are not enough questions in the database, or any at all,
     * an empty list is returned.
     *
     * @param size the size of the questions set, default value: 15
     * @return a list of unique and random questions
     */
    static def uniqueQuestionSet(int size = 15) {
        def questions = Question.all
        if (questions.size() < size) {
            Collections.shuffle(questions);
            questions
        } else {
            Collections.shuffle(questions);
            questions.subList(0, size)
        }
    }
}
