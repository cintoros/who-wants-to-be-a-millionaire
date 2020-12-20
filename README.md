# PCLS Module, Graded Exercise
based https://github.com/corradoparisi/who-wants-to-be-a-millionaire
requires java 8-13 as grails currently does not support java 14 see https://stackoverflow.com/a/61938486

* ./grailsw run-app
* curl -u admin:admin123 -X POST -o - localhost:8080/actuator/shutdown
  {"message":"Shutting down, bye..."}
