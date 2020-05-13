package webec

class Question {

    String questionText
    String correct
    String second
    String third
    String fourth

    String toString() {
        return "$questionText: correct: $correct other answers: ($second, $third, $fourth)"
    }

    static constraints = {
        questionText(blank: false, nullable: false)
        correct(blank: false, nullable: false)
        second(blank: false, nullable: false)
        third(blank: false, nullable: false)
        fourth(blank: false, nullable: false)
    }
}
