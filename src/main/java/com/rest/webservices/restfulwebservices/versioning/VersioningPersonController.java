package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Tiger");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob", "TheSecond"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Bob Tiger version");
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getFirstVersionOfPersonRequestParameterSecondVersion(){
        return new PersonV2(new Name("Bob", "TheSecond"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeader(){
        return new PersonV1("Bob Tiger version header");
    }

    @GetMapping(path="/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAccept(){
        return new PersonV1("Bob Tiger");
    }
}
