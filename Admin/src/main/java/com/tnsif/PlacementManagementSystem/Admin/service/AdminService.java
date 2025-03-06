package com.tnsif.PlacementManagementSystem.Admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tnsif.PlacementManagementSystem.Admin.model.Admin;
import com.tnsif.PlacementManagementSystem.Admin.repositry.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Create: Add a new admin
    public String addAdmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin added successfully!";
    }

    // Read: Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Read: Get an admin by ID
    public Admin getAdminById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    // Update: Update an existing admin
    public Admin updateAdmin(Admin admin) {
        if (adminRepository.existsById(admin.getAdminId())) {
            return adminRepository.save(admin);
        }
        return null; // Return null if admin does not exist
    }

    // Delete: Delete an admin by ID
    public String deleteAdmin(int id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return "Admin deleted successfully!";
        }
        return "Admin not found!";
    }
}
