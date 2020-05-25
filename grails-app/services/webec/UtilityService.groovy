package webec

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper
import org.apache.commons.lang.StringEscapeUtils

@Transactional
class UtilityService {

    /**
     * Saves domain object into db.
     * @param domainObject the domain object
     * @return the inserted instance.
     */
    static save(domainObject) {
        domainObject.save(failOnError: true, flush: true)
    }

    /**
     * Inserts production questions from OpentDB into db.
     *
     * Uses local data on failure e.g. website unavailable.
     * @return true if loading from online API successful
     */
    static boolean loadProductionQuestions(String apiURL = "https://opentdb.com/api.php?amount=50&category=9&difficulty=easy&type=multiple") {
        // from opentdb questions API:
        // https://opentdb.com/api.php?amount=50&category=9&difficulty=easy&type=multiple
        final def slurper = new JsonSlurper()
        def parsedJson
        def result = true
        try {
            // get question from online API.
            parsedJson = slurper.parse(new URL(apiURL))
            println("Loading API questions from " + apiURL + " ...")
        } catch (Exception ignored) {
            // use local questions in case of errors
            result = false
            println("Online API unavailable. Loading local questions ...")
            final def rawJson = "{\"response_code\":0,\"results\":[{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Virgin Trains, Virgin Atlantic and Virgin Racing, are all companies owned by which famous entrepreneur?   \",\"correct_answer\":\"Richard Branson\",\"incorrect_answers\":[\"Alan Sugar\",\"Donald Trump\",\"Bill Gates\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Where is the train station &quot;Llanfair&shy;pwllgwyngyll&shy;gogery&shy;chwyrn&shy;drobwll&shy;llan&shy;tysilio&shy;gogo&shy;goch&quot;?\",\"correct_answer\":\"Wales\",\"incorrect_answers\":[\"Moldova\",\"Czech Republic\",\"Denmark\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which company did Valve cooperate with in the creation of the Vive?\",\"correct_answer\":\"HTC\",\"incorrect_answers\":[\"Oculus\",\"Google\",\"Razer\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the most common surname Wales?\",\"correct_answer\":\"Jones\",\"incorrect_answers\":[\"Williams\",\"Davies\",\"Evans\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What was the name of the WWF professional wrestling tag team made up of the wrestlers Ax and Smash?\",\"correct_answer\":\"Demolition\",\"incorrect_answers\":[\"The Dream Team\",\"The Bushwhackers\",\"The British Bulldogs\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"In the video-game franchise Kingdom Hearts, the main protagonist, carries a weapon with what shape?\",\"correct_answer\":\"Key\",\"incorrect_answers\":[\"Sword\",\"Pen\",\"Cellphone\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What does a funambulist walk on?\",\"correct_answer\":\"A Tight Rope\",\"incorrect_answers\":[\"Broken Glass\",\"Balls\",\"The Moon\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"In past times, what would a gentleman keep in his fob pocket?\",\"correct_answer\":\"Watch\",\"incorrect_answers\":[\"Money\",\"Keys\",\"Notebook\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the largest organ of the human body?\",\"correct_answer\":\"Skin\",\"incorrect_answers\":[\"Heart\",\"large Intestine\",\"Liver\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which sign of the zodiac is represented by the Crab?\",\"correct_answer\":\"Cancer\",\"incorrect_answers\":[\"Libra\",\"Virgo\",\"Sagittarius\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"On a dartboard, what number is directly opposite No. 1?\",\"correct_answer\":\"19\",\"incorrect_answers\":[\"20\",\"12\",\"15\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What word represents the letter &#039;T&#039; in the NATO phonetic alphabet?\",\"correct_answer\":\"Tango\",\"incorrect_answers\":[\"Target\",\"Taxi\",\"Turkey\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which American president appears on a one dollar bill?\",\"correct_answer\":\"George Washington\",\"incorrect_answers\":[\"Thomas Jefferson\",\"Abraham Lincoln\",\"Benjamin Franklin\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is &quot;dabbing&quot;?\",\"correct_answer\":\"A dance\",\"incorrect_answers\":[\"A medical procedure\",\"A sport\",\"A language\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the nickname of the US state of California?\",\"correct_answer\":\"Golden State\",\"incorrect_answers\":[\"Sunshine State\",\"Bay State\",\"Treasure State\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is on display in the Madame Tussaud&#039;s museum in London?\",\"correct_answer\":\"Wax sculptures\",\"incorrect_answers\":[\"Designer clothing\",\"Unreleased film reels\",\"Vintage cars\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of these colours is NOT featured in the logo for Google?\",\"correct_answer\":\"Pink\",\"incorrect_answers\":[\"Yellow\",\"Blue\",\"Green\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the Spanish word for &quot;donkey&quot;?\",\"correct_answer\":\"Burro\",\"incorrect_answers\":[\"Caballo\",\"Toro\",\"Perro\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the French word for &quot;hat&quot;?\",\"correct_answer\":\"Chapeau\",\"incorrect_answers\":[\"Bonnet\",\" &Eacute;charpe\",\" Casque\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Five dollars is worth how many nickles?\",\"correct_answer\":\"100\",\"incorrect_answers\":[\"50\",\"25\",\"69\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Who is depicted on the US hundred dollar bill?\",\"correct_answer\":\"Benjamin Franklin\",\"incorrect_answers\":[\"George Washington\",\"Abraham Lincoln\",\"Thomas Jefferson\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What do the letters in the GMT time zone stand for?\",\"correct_answer\":\"Greenwich Mean Time\",\"incorrect_answers\":[\"Global Meridian Time\",\"General Median Time\",\"Glasgow Man Time\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which one of these is not a typical European sword design?\",\"correct_answer\":\"Scimitar\",\"incorrect_answers\":[\"Falchion\",\"Ulfberht\",\"Flamberge\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which American-owned brewery led the country in sales by volume in 2015?\",\"correct_answer\":\"D. G. Yuengling and Son, Inc\",\"incorrect_answers\":[\"Anheuser Busch\",\"Boston Beer Company\",\"Miller Coors\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"According to Sherlock Holmes, &quot;If you eliminate the impossible, whatever remains, however improbable, must be the...&quot;\",\"correct_answer\":\"Truth\",\"incorrect_answers\":[\"Answer\",\"Cause\",\"Source\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the name of Poland in Polish?\",\"correct_answer\":\"Polska\",\"incorrect_answers\":[\"Pupcia\",\"Polszka\",\"P&oacute;land\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What color is the &quot;Ex&quot; in FedEx Ground?\",\"correct_answer\":\"Green\",\"incorrect_answers\":[\"Red\",\"Light Blue\",\"Orange\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What was the first ever London Underground line to be built?\",\"correct_answer\":\"Metropolitan Line\",\"incorrect_answers\":[\"Circle Line\",\"Bakerloo Line\",\"Victoria Line\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"How tall is the Burj Khalifa?\",\"correct_answer\":\"2,722 ft\",\"incorrect_answers\":[\"2,717 ft\",\"2,546 ft\",\"3,024 ft\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of the following card games revolves around numbers and basic math?\",\"correct_answer\":\"Uno\",\"incorrect_answers\":[\"Go Fish\",\"Twister\",\"Munchkin\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What machine element is located in the center of fidget spinners?\",\"correct_answer\":\"Bearings\",\"incorrect_answers\":[\"Axles\",\"Gears\",\"Belts\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which sign of the zodiac comes between Virgo and Scorpio?\",\"correct_answer\":\"Libra\",\"incorrect_answers\":[\"Gemini\",\"Taurus\",\"Capricorn\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of the following presidents is not on Mount Rushmore?\",\"correct_answer\":\"John F. Kennedy\",\"incorrect_answers\":[\"Theodore Roosevelt\",\"Abraham Lincoln\",\"Thomas Jefferson\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What company developed the vocaloid Hatsune Miku?\",\"correct_answer\":\"Crypton Future Media\",\"incorrect_answers\":[\"Sega\",\"Sony\",\"Yamaha Corporation\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which country, not including Japan, has the most people of japanese decent?\",\"correct_answer\":\"Brazil\",\"incorrect_answers\":[\"China\",\"South Korea\",\"United States of America\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which candy is NOT made by Mars?\",\"correct_answer\":\"Almond Joy\",\"incorrect_answers\":[\"M&amp;M&#039;s\",\"Twix\",\"Snickers\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"In which fast food chain can you order a Jamocha Shake?\",\"correct_answer\":\"Arby&#039;s\",\"incorrect_answers\":[\"McDonald&#039;s\",\"Burger King\",\"Wendy&#039;s\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of the following is the IATA code for Manchester Airport?\",\"correct_answer\":\"MAN\",\"incorrect_answers\":[\"EGLL\",\"LHR\",\"EGCC\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the Zodiac symbol for Gemini?\",\"correct_answer\":\"Twins\",\"incorrect_answers\":[\"Fish\",\"Scales\",\"Maiden\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What zodiac sign is represented by a pair of scales?\",\"correct_answer\":\"Libra\",\"incorrect_answers\":[\"Aries\",\"Capricorn\",\"Sagittarius\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What nuts are used in the production of marzipan?\",\"correct_answer\":\"Almonds\",\"incorrect_answers\":[\"Peanuts\",\"Walnuts\",\"Pistachios\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"According to the nursery rhyme, what fruit did Little Jack Horner pull out of his Christmas pie?\",\"correct_answer\":\"Plum\",\"incorrect_answers\":[\"Apple\",\"Peach\",\"Pear\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Terry Gilliam was an animator that worked with which British comedy group?\",\"correct_answer\":\"Monty Python\",\"incorrect_answers\":[\"The Goodies&lrm;\",\"The League of Gentlemen&lrm;\",\"The Penny Dreadfuls\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"When someone is inexperienced they are said to be what color?\",\"correct_answer\":\"Green\",\"incorrect_answers\":[\"Red\",\"Blue\",\"Yellow\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"If you are caught &quot;Goldbricking&quot;, what are you doing wrong?\",\"correct_answer\":\"Slacking\",\"incorrect_answers\":[\"Smoking\",\"Stealing\",\"Cheating\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"The Flag of the European Union has how many stars on it?\",\"correct_answer\":\"12\",\"incorrect_answers\":[\"10\",\"14\",\"16\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the closest planet to our solar system&#039;s sun?\",\"correct_answer\":\"Mercury\",\"incorrect_answers\":[\"Mars\",\"Jupiter\",\"Earth\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the name of NASA&rsquo;s most famous space telescope?\",\"correct_answer\":\"Hubble Space Telescope\",\"incorrect_answers\":[\"Big Eye\",\"Death Star\",\"Millenium Falcon\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Earth is located in which galaxy?\",\"correct_answer\":\"The Milky Way Galaxy\",\"incorrect_answers\":[\"The Mars Galaxy\",\"The Galaxy Note\",\"The Black Hole\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Who is the author of Jurrasic Park?\",\"correct_answer\":\"Michael Crichton\",\"incorrect_answers\":[\"Peter Benchley\",\"Chuck Paluhniuk\",\"Irvine Welsh\"]}]}\n"
            parsedJson = slurper.parseText(rawJson)
        }
        parsedJson.results.each {
            def question = new Question(
                    questionText: unescapeHtml(it.question),
                    correct: unescapeHtml(it.correct_answer),
                    second: unescapeHtml(it.incorrect_answers.get(0)),
                    third: unescapeHtml(it.incorrect_answers.get(1)),
                    fourth: unescapeHtml(it.incorrect_answers.get(2))
            )
            println("Loading into db: " + question)
            save(question)
        }
        result
    }

    private static String unescapeHtml(String html) {
        StringEscapeUtils.unescapeHtml(html)
    }

    /**
     * Inserts dev questions into db.
     */
     static void loadDevelopmentQuestions() {
        println("Loading dev questions ...")

        save(new Question(questionText: "A?", correct: "A", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "B?", correct: "B", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "C?", correct: "C", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "D?", correct: "D", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "E?", correct: "E", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "F?", correct: "F", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "G?", correct: "G", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "H?", correct: "H", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "I?", correct: "I", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "J?", correct: "J", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "K?", correct: "K", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "L?", correct: "L", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "M?", correct: "M", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "N?", correct: "N", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "O?", correct: "O", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "P?", correct: "P", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "Q?", correct: "Q", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "R?", correct: "R", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "S?", correct: "S", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "T?", correct: "T", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "U?", correct: "U", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "V?", correct: "V", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "W?", correct: "W", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "X?", correct: "X", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "Y?", correct: "Y", second: "second", third: "third", fourth: "fourth"))
        save(new Question(questionText: "Z?", correct: "Z", second: "second", third: "third", fourth: "fourth"))
    }

}
