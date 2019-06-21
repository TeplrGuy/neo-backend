package com.neostarteon.backend.services;

import com.neostarteon.backend.models.Location;
import com.neostarteon.backend.models.User;
import com.neostarteon.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private LocationService locationService;

    public UserService(UserRepository userRepository, LocationService locationService) {
        this.userRepository = userRepository;
        this.locationService = locationService;
    }

    public User createUser(User user) {
        var userLocation = new Location()
                .setUser(user)
                .setLatitude(123456.0)
                .setLongitude(34334.1)
                .setCreatedOn(new Date());
        locationService.createLocation(userLocation);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long Id) {
        return userRepository.findById(Id).orElse(null);
    }


}
