import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';

@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent {

  constructor(public loginService: LoginService) { }

  logIn(event: any, username: string, password: string) {

    event.preventDefault();

    this.loginService.logIn(username, password);
  }
}
