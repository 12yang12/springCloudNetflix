package com.example.controller;

import com.example.entity.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {

    private final RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/findAll")
    public Collection<User> findAll() {
        return restTemplate.getForEntity("http://localhost:8010/user/findAll",
                Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<User> findAll2() {
        return restTemplate.getForObject("http://localhost:8010/user/findAll",
                Collection.class);
    }


    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return restTemplate.getForEntity("http://localhost:8010/user/findById/{id}",
                User.class, id).getBody();
    }

    @GetMapping("/findById2/{id}")
    public User findById2(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://localhost:8010/user/findById/{id}",
                User.class, id);
    }


    @PostMapping("/save")
    public void save(@RequestBody User user) {
        restTemplate.postForEntity("http://localhost:8010/user/save", user,
                null).getBody();
    }


    @PostMapping("/save2")
    public void save2(@RequestBody User user) {
        restTemplate.postForEntity("http://localhost:8010/user/save", user, null);
    }


    @PutMapping("/update")
    public void update(@RequestBody User user) {
        restTemplate.put("http://localhost:8010/user/update", user);
    }


    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        restTemplate.delete("http://localhost:8010/user/deleteById/{id}", id);
    }
}
