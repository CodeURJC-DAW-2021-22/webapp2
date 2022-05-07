import { Component, OnInit } from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";

declare var showPassword: any;
@Component({
  templateUrl: './register.component.html',
  styleUrls: ['../../../assets/css/loginregister.css']
})

export class RegisterComponent {

  newUser: boolean | undefined;
  User: User | undefined;

  removeImage:boolean | undefined;

  constructor(private service: UserService){}

  register(name: string,surname:string,email:string,password:string, address:string, categoria1:string, categoria2:string, categoria3:string){
    if(!this.User){

      this.User = {
        name:name, surname:surname, email:email, encodedPassword:password, address:address, categoria1:categoria1, categoria2:categoria2, categoria3:categoria3, products:[],
        roles:["USER"]};

      this.service.registerUser(this.User)
    }
    else {
      throw Error();
    }
  }
}
