import { Component, OnInit } from "@angular/core";

declare var showPassword: any;
@Component({
  templateUrl: './register.component.html',
  // styleUrls: ['../../../assets/css/style.component.css','../../../assets/css/styleLogin.component.css']
})

export class RegisterComponent implements OnInit {

  token: any;
  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }

  showPassword() {
    new showPassword();
  }
}
