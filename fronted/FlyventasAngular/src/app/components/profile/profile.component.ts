import { Component } from '@angular/core';
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
  styleUrls:["../../../assets/css/profile.css", "../../../assets/css/table.css"]
})
export class ProfileComponent {

  product: Product | undefined;
  products!: Product[];
  transactionsBuyer!: Transaction[];
  transactionsSeller!: Transaction[];
  counteoffer!: Counteroffer[];
  userprofile : User;
  idUrl!:number;
  check_id!: boolean;


  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              public productsService: ProductService, public loginService: LoginService, public userService: UserService,
              public tranServices: TransactionService, public counServices: CounterofferService) {

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

      this.tranServices.getTransactionsUserBuyer(this.idUrl).subscribe({
        next: show => this.transactionsBuyer= show,
        error: error => console.log(error)
      });

      this.tranServices.getTransactionsUserSeller(this.idUrl).subscribe({
        next: show => this.transactionsSeller= show,
        error: error => console.log(error)
      });

      this.counServices.getCounterofferUserAll(this.idUrl).subscribe({
        next: show => this.counteoffer= show,
        error: error => console.log(error)
      });







  }






}
