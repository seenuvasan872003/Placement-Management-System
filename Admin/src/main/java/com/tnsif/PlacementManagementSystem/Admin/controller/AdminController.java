package com.tnsif.PlacementManagementSystem.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tnsif.PlacementManagementSystem.Admin.model.Admin;
import com.tnsif.PlacementManagementSystem.Admin.service.AdminService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")  // Enable CORS for Angular frontend
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Create: Add a new admin
    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.addAdmin(admin));
    }

    // Read: Get all admins
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    // Read: Get an admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable int id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(404).body("Admin not found!");
        }
    }

    // Update: Update an existing admin
    @PutMapping("/update")
    public ResponseEntity<?> updateAdmin(@RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(admin);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.status(404).body("Admin not found for update!");
        }
    }

    // Delete: Delete an admin by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int id) {
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }
}
