package com.example.jpademo.api;

import com.example.jpademo.api.requests.RequestOne;
import com.example.jpademo.application.utils.nullableproperty.NullableProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DummyController {

    @PostMapping("/test/1")
    public ResponseEntity<String> endpointOne(@RequestBody RequestOne request)
    {
        if(request.text.isOverwrite())
            return ResponseEntity.ok(request.text.get());
        else
            return ResponseEntity.noContent().build();
    }


    @GetMapping("/test/2")
    public ResponseEntity<NullableProperty<String>> endpointOne()
    {
        var returnObj = new NullableProperty<>("Hey!");
        return ResponseEntity.ok(returnObj);
    }
}
