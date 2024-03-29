import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
    providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }
  postData(data) {
    return this.http.post<any>('http://localhost:5678/adduser',data,httpOptions);
  }
}