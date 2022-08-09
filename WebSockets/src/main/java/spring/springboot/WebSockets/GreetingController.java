package spring.springboot.WebSockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

// In Spring’s approach to working with STOMP messaging, STOMP messages can be routed to @Controller classes
@Controller
public class GreetingController {

    /*  This annotation ensures that, if a message is sent to the endpoint
        the greeting() method is called.
    */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingMessage greeting(HelloMessage helloMessage) throws Exception{
        Thread.sleep(1000); //simualted delay
        //The return value is broadcast to all subscribers of /topic/greetings, as specified in the @SendTo annotation
        return new GreetingMessage("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
    }
}
