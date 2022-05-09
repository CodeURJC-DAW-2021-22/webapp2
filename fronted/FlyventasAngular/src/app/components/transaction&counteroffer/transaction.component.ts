import { Component } from '@angular/core';
import { Product } from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import { LoginService } from "../../services/login.service";
import { ProductService } from "../../services/product.service";
import { Transaction } from "../../models/transaction.model";
import {User} from "../../models/user.model";
import {TransactionService} from "../../services/transaction.service";

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent {

  product!: Product;

  constructor(private router: Router, activatedRoute: ActivatedRoute,
              public productsService: ProductService, public loginService: LoginService,
              public transactionService: TransactionService) {

    const id = activatedRoute.snapshot.params['id'];
    productsService.getProduct(id).subscribe({

      next: product => this.product = product,
      error: error => console.error(error)
    });
  }

  newTransation() {
    let data = {
      id: this.product.id,
      title: this.product.title,
      description: this.product.description,
      category: this.product.category,
      price: this.product.price,
      isSold: this.product.isSold,
      image: this.product.image,
      user: this.product.user
    };
    //console.log(transaction)
    console.log(data)
    this.transactionService.addTransaction(data).subscribe({
      next: transaction => {},
      error: error => console.error(error,this.product),
    });
    this.router.navigate([""]);
  }

  getTodayDate() {
    let todayDate: Date = new Date();
    var date = new String;
    date.concat(todayDate.getDay() + "/" + todayDate.getMonth() + "/" + todayDate.getFullYear())
    return date;
  }

  cancel() {
    window.history.back();
  }
}
