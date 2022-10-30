package com.RestFulWebServicePart2.RestFulWebServicePart2.Internationalization;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MessageController {

    private MessageSource messageSource;
    MessageController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/message/{username}")
    public String welcome(@PathVariable String username){

        Locale locale = LocaleContextHolder.getLocale();

        String name[] = new String[]{username};

        return messageSource.getMessage("welcome.text",name,"Default Message",locale);
    }
}
