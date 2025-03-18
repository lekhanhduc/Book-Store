package vn.khanhduc.bookstore.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDetailResponse {
    private String firstName;
    private String lastName;
    private String email;
}
