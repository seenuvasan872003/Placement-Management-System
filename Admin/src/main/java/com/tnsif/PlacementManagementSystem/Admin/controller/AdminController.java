package com.tnsif.PlacementManagementSystem.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tnsif.PlacementManagementSystem.Admin.model.Admin;
import com.tnsif.PlacementManagementSystem.Admin.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Create: Add a new admit
    @PostMapping("/add")
    public String addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    // Read: Get all admits
    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // Read: Get an admit by ID
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
    }

    // Update: Update an existing admin
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    // Delete: Delete an admit by ID
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable int id) {
        return adminService.deleteAdmin(id);
    }
}
