package io.aturanj.java_vert.x_rest_api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        vertx.createHttpServer().requestHandler(req -> {
            
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("This message is from Vert.x HTTP Server");
            
        }).listen(8888, http -> {
            
            if (http.succeeded()) {
                
                startPromise.complete();
                System.out.println("HTTP server started on port 8888");
                
            } else {
                startPromise.fail(http.cause());
            }
        });
    }
}
