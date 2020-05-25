package webec

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import grails.validation.ValidationException
import spock.lang.Specification

class UtilityServiceSpec extends Specification implements DataTest, ServiceUnitTest<UtilityService> {

    def setupSpec() {
        mockDomain Question
    }

    def setup() {
        // empty
    }

    def cleanup() {
        // empty
    }

    void 'test load dev questions'() {
        given:
        def mock = Mock(UtilityService)

        when:
        mock.loadDevelopmentQuestions()

        then:
        Question.all.size() == 26
    }

    void 'test load prod questions'() {
        given:
        def mock = Mock(UtilityService)

        when:
        mock.loadProductionQuestions()

        then:
        Question.all.size() == 50
    }

    void 'test expect loadProdQuestions returns true on other questions from OpentDB'() {
        given:
        def mock = Mock(UtilityService)

        when:
        def success = mock.loadProductionQuestions("https://opentdb.com/api.php?amount=10&category=22&difficulty=easy&type=multiple")

        then:
        Question.all.size() == 10
        assert success
    }

    void 'test expect loadProdQuestions returns false on API error'() {
        given:
        def mock = Mock(UtilityService)

        when:
        def success = mock.loadProductionQuestions("InvalidURL")

        then:
        Question.all.size() == 50 // the local 50 questions remain
        assert !success
    }


        void 'test expect NullPointerException on null question'() {
        given:
        Question question = null
        def mock = Mock(UtilityService)

        when:
        mock.save(question)

        then:
        thrown NullPointerException
    }

    void 'test expect ValidationException on empty init question'() {
        given:
        Question question = new Question()
        def mock = Mock(UtilityService)

        when:
        mock.save(question)

        then:
        thrown ValidationException
    }

    void 'test expect successful insert'() {
        given:
        Question question = new Question(questionText: "A?", correct: "A", second: "second", third: "third", fourth: "fourth")
        def mock = Mock(UtilityService)

        when:
        mock.save(question)

        then:
        Question.count == 1
        Question.all[0] == question // returned question same as saved one
    }




}
