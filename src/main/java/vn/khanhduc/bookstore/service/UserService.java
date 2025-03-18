package vn.khanhduc.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.khanhduc.bookstore.dto.request.UserCreationRequest;
import vn.khanhduc.bookstore.dto.response.UserCreationResponse;
import vn.khanhduc.bookstore.dto.response.UserDetailResponse;
import vn.khanhduc.bookstore.model.User;
import vn.khanhduc.bookstore.repository.UserRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public UserCreationResponse createUser(UserCreationRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        userRepository.save(user);
        return UserCreationResponse.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public List<UserDetailResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserDetailResponse.builder()
                        .email(user.getEmail())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .build())
                .toList();
    }

}
