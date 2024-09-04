package com.raihanorium.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import lombok.extern.log4j.Log4j2;

@Controller("/logger")
@Log4j2
public class LoggerController {

    @Get("/log/{exceptionType}")
    public void logRuntimeException(@PathVariable Integer exceptionType) {
        try {
            switch (exceptionType) {
                case 1:
                    throw new RuntimeException("This is a random exception thrown from LogGenerationJob.");
                case 2:
                    throw new NullPointerException("This is a random exception thrown from LogGenerationJob.");
                case 3:
                    throw new IllegalStateException("This is a random exception thrown from LogGenerationJob.");
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                log.error(e.getMessage(), e);
            } else {
                log.info(e.getMessage(), e);
            }
        }
    }
}
