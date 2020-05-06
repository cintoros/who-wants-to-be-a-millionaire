package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class QuestionSpec extends Specification implements DomainUnitTest<Question> {

    def setup() {
    }

    def cleanup() {
    }

    void "questionText cannot be null or blank"() {
        expect:
        domain != null
        when:
        domain.questionText = null
        then:
        !domain.validate(['questionText'])
        domain.errors['questionText'].code == 'nullable'

        expect:
        domain != null
        when:
        domain.questionText = '  '
        then:
        !domain.validate(['questionText'])
        domain.errors['questionText'].code == 'blank'
    }

    void "correct cannot be null or blank"() {
        expect:
        domain != null
        when:
        domain.correct = null
        then:
        !domain.validate(['correct'])
        domain.errors['correct'].code == 'nullable'

        expect:
        domain != null
        when:
        domain.correct = '  '
        then:
        !domain.validate(['correct'])
        domain.errors['correct'].code == 'blank'
    }

    void "second cannot be null or blank"() {
        expect:
        domain != null
        when:
        domain.second = null
        then:
        !domain.validate(['second'])
        domain.errors['second'].code == 'nullable'

        expect:
        domain != null
        when:
        domain.second = '  '
        then:
        !domain.validate(['second'])
        domain.errors['second'].code == 'blank'
    }

    void "third cannot be null or blank"() {
        expect:
        domain != null
        when:
        domain.third = null
        then:
        !domain.validate(['third'])
        domain.errors['third'].code == 'nullable'

        expect:
        domain != null
        when:
        domain.third = '  '
        then:
        !domain.validate(['third'])
        domain.errors['third'].code == 'blank'
    }

    void "fourth cannot be null or blank"() {
        expect:
        domain != null
        when:
        domain.fourth = null
        then:
        !domain.validate(['fourth'])
        domain.errors['fourth'].code == 'nullable'

        expect:
        domain != null
        when:
        domain.fourth = '  '
        then:
        !domain.validate(['fourth'])
        domain.errors['fourth'].code == 'blank'
    }

}
