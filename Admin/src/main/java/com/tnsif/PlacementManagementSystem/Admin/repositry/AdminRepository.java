package com.tnsif.PlacementManagementSystem.Admin.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.PlacementManagementSystem.Admin.model.Admin;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);

    Optional<Admin> findByEmail(String email);
}
