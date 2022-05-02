import { User } from './../models/user.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';
import { Router } from '@angular/router';

const BASE_URL = '/api/users/';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http: HttpClient, private router: Router) {
  }

  getUser(id: number | string) {
    return this.http.get(BASE_URL + id).pipe(map(
      response => response as User
    ))
  }

  registerUser(User: User) {
    return this.http.post(BASE_URL, User, {withCredentials: true}).subscribe(
      _ => this.router.navigate(['login'])
    );
  }

  deleteUser(id: number | string) {
    return this.http.put(BASE_URL + id, {withCredentials: true}).pipe(map(
      response => response,
      error => errorIgnore(error, 400, "deleteUser")
    ))
  }

  updateUser(user: User) {
    return this.http.put(BASE_URL, user, {withCredentials: true}).pipe(map(
      response => response,
      error => errorIgnore(error, 400, "updateUser")
    ));
  }
}
function errorIgnore(error: any, errorNum: number, funcName: string) {
  if (error.status != errorNum) {
    console.error('Unexpected Error on' + funcName)
  }
}
