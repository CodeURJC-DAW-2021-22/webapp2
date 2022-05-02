import { Component, OnInit } from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

declare var showPassword: any;
@Component({
  templateUrl: './register.component.html',
  // styleUrls: ['../../../assets/css/style.component.css','../../../assets/css/styleLogin.component.css']
})

export class RegisterComponent {

  token: any;
  constructor(private router: Router, activatedRoute: ActivatedRoute) {

  }
  showPassword() {
    new showPassword();
  }

  submit() {
    this.router.navigate([""]);
  }
}
