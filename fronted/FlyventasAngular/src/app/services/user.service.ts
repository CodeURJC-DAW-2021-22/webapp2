import { User } from './../models/user.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';
import { Router } from '@angular/router';

const BASE_URL = 'api/users/';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http: HttpClient, private router: Router) {
  }

  getUsers() {
    return this.http.get(BASE_URL).pipe(map(
      response => response as User[]
    ))
  }

  getUserLogged() {
    return this.http.get(BASE_URL + "me").pipe(map(
      response => response as User

    ))
  }


  registerUser(User: User) {
    return this.http.post(BASE_URL, User).subscribe(
      _ => this.router.navigate(['login'])
    );
  }

  deleteUser(id: number) {
    return this.http.delete(BASE_URL + id).pipe(
      map(response => response as User)
  )
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
