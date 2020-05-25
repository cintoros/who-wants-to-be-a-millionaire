package webec

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

@Rollback
@Integration
class PlayServiceSpec extends Specification implements ServiceUnitTest<PlayService> {

    def setup() {
      // empty
    }

    def cleanup() {
        // empty
    }

    void 'test removeTwoWrongAnswers'() {
        when:
        def updatedQuestion = service.removeTwoWrongAnswersFromQuestion(1)

        then:
        updatedQuestion.correct != null
        updatedQuestion.questionText != null

        updatedQuestion.second == null
        updatedQuestion.third == null

        updatedQuestion.fourth != null
    }
}
