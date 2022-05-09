import {Component, Inject, Renderer2} from '@angular/core';
import {Product} from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../../services/login.service";
import { ProductService } from "../../services/product.service";
import { Transaction } from "../../models/transaction.model";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";
import {TransactionService} from "../../services/transaction.service";
import {CounterofferService} from "../../services/counteoffer.service";
import {Counteroffer} from "../../models/counteroffer.model";



@Component({
  selector: 'app-profile',
  templateUrl: '../profile/profile.component.html',
  styleUrls:["../../../assets/css/profile.css", "../../../assets/css/table.css", "../../../assets/css/style.css", "../../../assets/css/profile.css"]
})
export class ProfileComponent {

  product: Product | undefined;
  products!: Product[];
  transactionsBuyer!: Transaction[];
  transactionsSeller!: Transaction[];
  counteoffer!: Counteroffer[];
  userprofile : User;
  idUser!:number;
  check_id!: boolean;
  idP: number;
  category: string;
  description: string;
  price: number;
  title: string;


    constructor(private router: Router, private activatedRoute: ActivatedRoute,
              public productsService: ProductService, public loginService: LoginService, public userService: UserService,
              public tranServices: TransactionService, public counServices: CounterofferService) {

    this.userprofile = {
      products: [],
      roles: [],
      name: "hola",
      surname: "string",
      email: "string",
      address: "string",
      encodedPassword:"",
      categoria1: "",
      categoria2: "",
      categoria3: "",
    }

    this.product = {
      category: "", description: "", image: false, isSold: false, price: 0, title: ""

    }



    this.userService.getUserLogged().subscribe({
      next: response => {
        this.userprofile = response, this.idUser = response.id,

          this.productsService.getProductUser(this.idUser).subscribe({
          next: show => this.products= show,
          error: error => console.log(error)

        }),
          this.tranServices.getTransactionsUserBuyer(this.idUser).subscribe({
          next: show => {this.transactionsBuyer= show, console.log(show)},
          error: error => console.log(error)
        });

          this.tranServices.getTransactionsUserSeller(this.idUser).subscribe({
            next: show => this.transactionsSeller= show,
            error: error => console.log(error)
        });

          this.counServices.getCounterofferUserAll(this.idUser).subscribe({
            next: show => this.counteoffer= show,
            error: error => console.log(error)
        });

      },
      error: error => this.router.navigate(['/login'])
    })


  }

  updateProducts(id:number){
    let prod = {
      id: id, category: this.category, description: this.description, price: this.price, title:this.title
    };

    this.productsService.updateProduct(prod).subscribe({
      next: product => this.products,
      error: error => console.error(error,prod),
    })
  }

  acceptOffer(){

  }



}
