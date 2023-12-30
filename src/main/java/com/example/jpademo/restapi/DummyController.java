package com.example.jpademo.restapi;

import com.example.jpademo.restapi.requests.FirstRequest;
import com.example.jpademo.restapi.requests.NullableRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @PostMapping("/1")
    public String firstEndpoint(@RequestBody FirstRequest request)
    {
        if (request.name == null) return "No value provided";
        if (request.name.isPresent()) return request.name.getValue();
        return "None?";
    }

    @PostMapping("/2")
    public String secondEndpoint(@RequestBody NullableRequest request)
    {
        if (request.name.isPresent()) return request.name.get();
        return "None?";
    }
}
