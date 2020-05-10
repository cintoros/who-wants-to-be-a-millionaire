package webec

class BootStrap {

    def init = { servletContext ->
        save(new Question(questionText: "Was ist der grösste Planet in unserem Sonnensystem?", correct: "Jupiter", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "Wer wurde 2006 in der Fussball Weltmeisterschaft sieger?", correct: "Italien", second: "Frankreich", third: "Argentinien", fourth: "Brasilien"))
        save(new Question(questionText: "Wie hoch ist das Empire State Building bis zur Spitze?", correct: "443m", second: "603m", third: "754m", fourth: "1021m"))

        save(new Question(questionText: "A?", correct: "A", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "B?", correct: "B", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "C?", correct: "C", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "D?", correct: "D", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "E?", correct: "E", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "F?", correct: "F", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "G?", correct: "G", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "H?", correct: "H", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "I?", correct: "I", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "J?", correct: "J", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "K?", correct: "K", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "L?", correct: "L", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "M?", correct: "M", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "N?", correct: "N", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "O?", correct: "O", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "P?", correct: "P", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "Q?", correct: "Q", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "R?", correct: "R", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "S?", correct: "S", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "T?", correct: "T", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "U?", correct: "U", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "V?", correct: "V", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "W?", correct: "W", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "X?", correct: "X", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "Y?", correct: "Y", second: "Merkur", third: "Mars", fourth: "Saturn"))
        save(new Question(questionText: "Z?", correct: "Z", second: "Merkur", third: "Mars", fourth: "Saturn"))
    }
    def destroy = {
    }

    static save(domainObject) {
        domainObject.save(failOnError: true, flush: true)
    }
}
