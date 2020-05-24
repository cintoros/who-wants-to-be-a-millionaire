# WebEngineering Module, Graded Exercise

## Commit Proposal
Matriculation Number: 17-549-981

### Wer wird Millionär
Um sich einen gemütlichen Spieleabend in der Familie machen zu können, 
sind Quizzes immer etwas tolles. 

Die Idee wäre, dass ein Spiele-Moderator sich viele Fragen anzeigen lassen kann, die er dann anderen Personen vorlesen kann. 
Dabei sieht er vier Antwortmöglichkeiten und die richtige Lösung. Der Moderator teilt den Spielern dann mündlich mit, ob sie die 
richtige Antwort gewählt haben. 

Fragen kommen in einer zufälligen Reihenfolge.

Ein Admin User verwaltet den Fragekatalog und kann Fragen erstellen, bearbeiten und löschen. 

#### Zusätzliche Ideen, falls Zeit vorhanden:
- Die richtige Lösung wird dem Moderator nicht sofort angezeigt, sondern kann nachträglich eingeblendet werden. 
  Damit kann dieser mitraten und zusätzlich könnte der Bildschirm am TV angeschlossen werden und die Spieler können die
  Fragen auch lesen.  

- Antwortmöglichkeiten haben eine zufällige Reihenfolge.  

- Wer wird Millionär ist tatsächlich spielbar auf der App.
    * Es werden zufällig 15 Fragen aus dem Katalog genommen.
    * Bei einer falschen Antwort ist das Spiel beendet.
    * 50% Joker, der nur einmal eingesetzt werden kann und zwei falsche Antworten eliminiert.
    * Highscore Tabelle, sortiert nach Anzahl richtigen Antworten (bei Spielbeginn kann der Spielernamen eingegeben werden).

## Project confirmation
Sie haben sich viel vorgenommen. Aber das ist eine tolle Idee und sie umzusetzen macht sicherlich Spass.
Fangen Sie klein an und erweitern Sie das Spiel mit Zusatzfunktionen, falls die Zeit reicht. Sie dürfen anfangen.
Viel Spass!

## Project delivery <to be filled by student>
How to start the project: (if other than `grailsw run-app`)

How to test the project:  (if other than `grailsw test-app`)

Hand-written, static HTML 
project description:      (if other than `index.html` in project root directory)

External contributions: -

Other comments: -

I'm particular proud of:
    
## This is what I'm proud of
I would like to point out a few points that I have implemented well in terms of implementation.
            
#### Anti Cheat Detection 
If a player looses the game, presses the back button to "reanswer" his question, the anti cheat detection get's triggered and the game is aborted.

#### Zoom Logo
Who wants to be a millionaire logo on the home page has an "on hover" zoom animation. 
Actually this has taken a lot of time, but it was worth it, because the page looks less static now.
            
#### Design and layout
            
Design and layout in general is very well done. Bootstrap 4 runs through the application 
and gives it a uniform and stable touch.
            
#### 50/50 wild cards
            
The 50/50 Joker is available in game mode and can only be used once per game. Thereby two wrong answers 
are eliminated from the current questions.
            
#### Responsive website
            
The website in general is dynamic: the 50/50 joker disappears as soon as it is played. 
Dynamic button names are also available in the moderator view. The button changes from "Show Answer" to "Hide Answer"
as soon as it is clicked. "Clear Answer" sets the button always go back to "Show Answer" as well.
I have experimented a lot with Javascript for these features and came up with very good results.
            
#### Initial Question Catalogue
Via a JSON-API questions can be loaded dynamically and users can directly open the app and play!

#### Valid HTML and CSS
Every HTML and CSS page has been validated with "https://validator.w3.org/nu/" and contains no errors anymore. 
The moderator view was the most difficult view to provide without errors.
            
            

## Project grading 
< to be filled by lecturer>
