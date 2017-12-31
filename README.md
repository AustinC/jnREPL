# jnREPL
This library facilitates embedding a Clojure nREPL within a Java application.
The API has two static methods:

    Jnrepl.startRepl();    // start an nREPL server
    Jnrepl.shutdownRepl(); // shut it down


The repl port defaults to `9090`. It can be set with the JVM arg `-Djnrepl.port=9091`


### Example connecting with leiningen

`$ lein repl :connect localhost:9090`

### Maven coordinates

    <dependency>
       <groupId>com.github.austinc</groupId>
        <artifactId>jnrepl</artifactId>
        <version>1.0</version>
    </dependency>
