package vn.khanhduc.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.khanhduc.bookstore.dto.request.UserCreationRequest;
import vn.khanhduc.bookstore.dto.response.UserCreationResponse;
import vn.khanhduc.bookstore.model.User;
import vn.khanhduc.bookstore.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public UserCreationResponse createUser(UserCreationRequest request) {
        // 1. Xác định request và response gồm những thông tin nào

        // 2. Triển khai
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
//        User user = new User();
//        user.setEmail(request.getEmail());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setPassword(request.getPassword());

          User user = User.builder()
                  .email(request.getEmail())
                  .password(request.getPassword())
                  .firstName(request.getFirstName())
                  .lastName(request.getLastName())
                  .build();

        userRepository.save(user);
//        UserCreationResponse response = new UserCreationResponse();
//        response.setEmail(user.getEmail());
//        response.setFirstName(user.getFirstName());
//        response.setLastName(user.getLastName());
//
//        return response;

        return UserCreationResponse.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

}
