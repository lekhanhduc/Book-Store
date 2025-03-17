package vn.khanhduc.bookstore.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationResponse {
    private String email;
    private String firstName;
    private String lastName;
}
