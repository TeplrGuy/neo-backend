package com.neostarteon.backend.controllers;

import com.neostarteon.backend.models.Location;
import com.neostarteon.backend.models.User;
import com.neostarteon.backend.services.LocationService;
import com.neostarteon.backend.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private LocationService locationService;
    private UserService userService;

    public LocationController(LocationService locationService, UserService userService) {
        this.locationService = locationService;
        this.userService = userService;
    }

    @GetMapping("/{Id}")
    @ResponseBody
    @ApiOperation(value = "", authorizations = {@Authorization(value = "Bearer")})
    public Location getLocation(@PathVariable Long Id) {
        return locationService.findByUserId(Id);
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "", authorizations = {@Authorization(value = "Bearer")})
    public ResponseEntity updateLocation(@RequestBody Location location) {

        var user = userService.getUserById(location.getId());
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        location.setLatitude(location.getLatitude());
        location.setLongitude(location.getLongitude());
        location.setUpdatedOn(new Date());
        location.setCreatedOn(location.getCreatedOn());

        return ok(locationService.createLocation(location));

    }
}
