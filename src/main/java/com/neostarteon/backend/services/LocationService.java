package com.neostarteon.backend.services;

import com.neostarteon.backend.models.Location;
import com.neostarteon.backend.repositories.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location findByUserId(Long Id) {
        return locationRepository.findByUserId(Id);
    }


}
