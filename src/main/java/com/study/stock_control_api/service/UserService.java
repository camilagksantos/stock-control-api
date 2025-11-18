package com.study.stock_control_api.service;

import com.study.stock_control_api.controller.mapper.UserMapper;
import com.study.stock_control_api.dto.request.AuthRequestDTO;
import com.study.stock_control_api.dto.request.UserRequestDTO;
import com.study.stock_control_api.dto.response.AuthResponseDTO;
import com.study.stock_control_api.dto.response.UserResponseDTO;
import com.study.stock_control_api.model.User;
import com.study.stock_control_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserResponseDTO create(UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toResponseDTO(user);
    }

    @Transactional
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userMapper.updateEntityFromDTO(dto, user);
        User updatedUser = userRepository.save(user);
        return userMapper.toResponseDTO(updatedUser);
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    public AuthResponseDTO authenticate(AuthRequestDTO authRequest) {
        Optional<User> userOptional = userRepository
                .findByEmailAndPassword(authRequest.email(), authRequest.password());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserResponseDTO userResponse = userMapper.toResponseDTO(user);

            return new AuthResponseDTO(
                    true,
                    "Authentication successful",
                    userResponse
            );
        } else {
            return new AuthResponseDTO(
                    false,
                    "Invalid email or password",
                    null
            );
        }
    }
}
