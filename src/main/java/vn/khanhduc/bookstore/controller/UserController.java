package vn.khanhduc.bookstore.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.khanhduc.bookstore.dto.request.UserCreationRequest;
import vn.khanhduc.bookstore.dto.response.UserCreationResponse;
import vn.khanhduc.bookstore.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserCreationResponse createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

}
