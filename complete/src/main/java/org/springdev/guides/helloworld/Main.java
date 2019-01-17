package org.springdev.guides.helloworld;

import ratpack.server.RatpackServer;

public class Main {
    public static void main(String[] args) throws Exception {
        RatpackServer.start(server ->
                server.handlers( chain ->
                        chain.get("hello", ctx -> ctx.render("Hello, World!"))
                             .get("hello/:name", ctx ->
                                    ctx.render("Hello, " + ctx.getPathTokens().get("name") + "!"))
        ));
    }
}
