# jnREPL
This library facilitates embedding a Clojure nREPL within a Java application.
The API has two methods:

    Jnrepl.startRepl();
    Jnrepl.shutdownRepl();


The repl port defaults to `9090`. It can be set with the JVM arg `-Djnrepl.port=9091`


### Example connecting with leiningen

`$ lein repl :connect localhost:9090`
