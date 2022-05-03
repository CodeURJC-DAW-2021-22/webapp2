import { Component } from '@angular/core';
import {Product} from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../../services/login.service";
import { ProductService } from "../../services/product.service";
import { Transaction } from "../../models/transaction.model";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";


@Component({
  selector: 'app-profile',
  templateUrl: '../profile/profile.component.html',
  styleUrls:["../../../assets/css/profile.css", "../../../assets/css/table.css"]
})
export class ProfileComponent {

  product: Product | undefined;
  products!: Product[];
  transactions: Transaction[] = [];
  userprofile : User;
  idUrl!:number;
  check_id!: boolean;


  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              public productsService: ProductService, public loginService: LoginService, public userService: UserService) {

    this.idUrl = activatedRoute.snapshot.params['id'];


  }

  ngOnInit(){

      this.userprofile = this.loginService.currentUser()
      if(this.userprofile.id==this.idUrl){
        this.check_id = true
      }else{
        this.check_id = false
      }

      this.userService.getUser(this.idUrl).subscribe({
        next: show => this.userprofile = show,
        error: error => console.log(error)
      });

      this.productsService.getProductUser(this.idUrl).subscribe({
        next: show => this.products= show,
        error: error => console.log(error)
      });




  }






}
