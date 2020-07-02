# jnREPL
This library facilitates embedding a Clojure nREPL within a Java application.
The API has two static methods:

    Jnrepl.startRepl(9091L);  // start an nREPL server
    Jnrepl.shutdownRepl(); // shut it down


The repl port defaults to `9090`. This default can overriden with the JVM arg `-Djnrepl.port=9091`


### Example connecting with leiningen

`$ lein repl :connect localhost:9090`

### Maven coordinates

    <dependency>
       <groupId>com.github.austinc</groupId>
        <artifactId>jnrepl</artifactId>
        <version>1.2</version>
    </dependency>

Compatible with JVM 1.6+
