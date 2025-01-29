package fr.efrei.rag.web.rest;

import fr.efrei.rag.web.dto.Sample;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/samples")
public class SampleResource {

    @GetMapping("/{value}")
    public String hello(@PathVariable(value = "value", required = false) final String value) {
        return "Hello World " + value + " !";
    }

    @GetMapping("/dto/{value}")
    public Sample helloJson(@PathVariable(value = "value", required = false) final String value) {
        return new Sample("Hello World " + value + " !");
    }


}