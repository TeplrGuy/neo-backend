package com.neostarteon.backend.repositories;

import com.neostarteon.backend.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByUserId(Long Id);
}
