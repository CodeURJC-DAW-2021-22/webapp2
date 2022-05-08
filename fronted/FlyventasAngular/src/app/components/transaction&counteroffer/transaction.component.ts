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
    const transaction: Transaction ={
      date: this.getTodayDate(),
      price: this.product?.price,
      product: this.product,
      buyer: this.loginService.currentUser(),
      seller: this.product?.user
    }
    this.transactionService.addTransaction(transaction).subscribe();
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
