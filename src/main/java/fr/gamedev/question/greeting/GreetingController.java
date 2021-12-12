package fr.gamedev.question.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author djer1
 */
@RestController
public class GreetingController {
    /**
     * Greeting template message.
     */
    private static final String TEMPLATE = "Hello, %s!";
    /**
     * Greeting id.
     */
    private final AtomicLong counter = new AtomicLong();
    /**
     * Greeting message.
     * @param name of the user.
     * @return the greeting message.
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")final String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
