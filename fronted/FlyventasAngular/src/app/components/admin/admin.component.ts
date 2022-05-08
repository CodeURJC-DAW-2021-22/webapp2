import {Component, Inject, OnInit, Renderer2} from '@angular/core';
import {Product} from "../../models/product.model";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../../services/login.service";
import { ProductService } from "../../services/product.service";


@Component({
  templateUrl: '../admin/admin.component.html',
  styleUrls:["../../../assets/css/profile.css", "../../../assets/css/table.css", "../../../assets/css/style.css", "../../../assets/css/profile.css"]
})
export class AdminComponent implements OnInit{


  userprofile : User;
  userss: User[];
  products:Product[];

  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              public productsService: ProductService, public loginService: LoginService, public userService: UserService){


    this.userService.getUserLogged().subscribe({
      next: response =>{this.userprofile = response;
        if(this.userprofile.email != "s.rusu.2019@gmail.com"){
          this.router.navigate(['/home'])}; console.log(response);
        },
      error: error => this.router.navigate(['/login'])
      })

  }

  ngOnInit() {


    this.userService.getUsers().subscribe({
      next: response => this.userss =response,
      error: error => console.log(error)
    })

    this.productsService.getProducts().subscribe({
      next: response => this.products =response,
      error: error => console.log(error)
    })

  }



  deleteUser(id:number){
    this.userService.deleteUser(id).subscribe({
      next: next => this.router.navigate(['/admin']),
      error: error => console.log(error)
    })
    window.location.reload()
  }
  deleteproduct(id:number){
    this.productsService.deleteProduct(id).subscribe({
      next: next => this.router.navigate(['/admin']),
      error: error => console.log(error)
    })
    window.location.reload()
  }



}
