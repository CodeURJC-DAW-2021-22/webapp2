import { Component } from '@angular/core';
import {Product} from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../services/product.service";
import {LoginService} from "../../services/login.service";
import { Counteroffer } from "../../models/counteroffer.model";
import {CounterofferService} from "../../services/counteoffer.service";

@Component({
  selector: 'app-counteroffer',
  templateUrl: './counteroffer.component.html'

})
export class CounterofferComponent {

  product!: Product;
  constructor(private router: Router, activatedRoute: ActivatedRoute,
              public productsService: ProductService, public loginService: LoginService,
              public counterofferService: CounterofferService) {

    const id = activatedRoute.snapshot.params['id'];
    productsService.getProduct(id).subscribe({

      next: product => this.product = product,
      error: error => console.error(error)
    });
  }

  newCounteroffer(newPrice: string) {
    let todayDate: Date = new Date();
    var price: number = + newPrice;

    let counteroffer ={
      date: todayDate,
      newPrice: price,
      product: this.product,
      transmitter: this.loginService.currentUser(),
      receiver: this.product?.user
    }
    this.counterofferService.addCounteroffer(counteroffer).subscribe();
    this.router.navigate([""]);
  }

  cancel() {
    window.history.back();
  }
}
