import { Component, OnInit } from '@angular/core';
import { AdminService } from './admin.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  adminDetails: any[] = [];
  newAdmin = { adminId: null, username: '', email: '', password: '' };
  editMode = false;

  constructor(private adminService: AdminService) {}

  ngOnInit() {
    this.fetchAdmins();
  }

  fetchAdmins() {
    this.adminService.getAdmins().subscribe(
      (data) => this.adminDetails = data,
      (error) => console.error('Error fetching admins:', error)
    );
  }

  addAdmin() {
    if (!this.newAdmin.adminId || !this.newAdmin.username || !this.newAdmin.email || !this.newAdmin.password) {
      alert('All fields are required');
      return;
    }
    this.adminService.addAdmin(this.newAdmin).subscribe(() => {
      this.fetchAdmins();
      this.resetForm();
    });
  }

  updateAdmin() {
    this.adminService.updateAdmin(this.newAdmin).subscribe(() => {
      this.fetchAdmins();
      this.resetForm();
      this.editMode = false;
    });
  }

  deleteAdmin(adminId: number) {
    if (confirm('Are you sure you want to delete this admin?')) {
      this.adminService.deleteAdmin(adminId).subscribe(() => this.fetchAdmins());
    }
  }

  editAdmin(admin: any) {
    this.newAdmin = { ...admin };
    this.editMode = true;
  }

  cancelEdit() {
    this.resetForm();
    this.editMode = false;
  }

  private resetForm() {
    this.newAdmin = { adminId: null, username: '', email: '', password: '' };
  }
}