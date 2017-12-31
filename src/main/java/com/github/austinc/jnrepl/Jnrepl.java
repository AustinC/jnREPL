package com.github.austinc.jnrepl;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jnrepl {

    final static Logger logger = LoggerFactory.getLogger(Jnrepl.class);

    private static Object serverInstance = null;

    /**
     * Start a clojure nREPL server
     */
    public static synchronized void startRepl() {

        if (null != serverInstance) {
            return;
        }

        try {
            IFn require = Clojure.var("clojure.core", "require");
            require.invoke(Clojure.read("clojure.tools.nrepl.server"));

            Long port = Long.parseLong(System.getProperty("jnrepl.port", "9090"));
            IFn server = Clojure.var("clojure.tools.nrepl.server", "start-server");
            serverInstance = server.invoke(Clojure.read(":port"), port);

            logger.info("Started clojure nREPL on port {}", port);
        }
        catch (Throwable e) {
            logger.error("Error starting nrepl", e);
        }
    }

    /**
     * Shutdown the nREPL server
     */
    public static synchronized void shutdownRepl() {
        logger.info("Shutting down nrepl");
        if (null == serverInstance) {
            return;
        }

        IFn shutdownFn = Clojure.var("clojure.tools.nrepl.server", "stop-server");
        shutdownFn.invoke(serverInstance);
        serverInstance = null;
    }
}
