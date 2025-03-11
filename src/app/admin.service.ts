import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl = 'http://localhost:8080/admin';

  constructor(private http: HttpClient) {}

  getAdmins(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/all`);
  }

  addAdmin(admin: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/add`, admin);
  }

  updateAdmin(admin: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/update`, admin);
  }

  deleteAdmin(adminId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${adminId}`);
  }
}