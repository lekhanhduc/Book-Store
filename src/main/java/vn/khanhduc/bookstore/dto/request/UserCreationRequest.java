package vn.khanhduc.bookstore.dto.request;

import lombok.Getter;

@Getter
public class UserCreationRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
