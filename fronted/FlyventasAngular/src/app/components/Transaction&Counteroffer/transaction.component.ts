import { Component } from '@angular/core';
import {Product} from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../../services/login.service";
import { ProductsService } from "../../services/products.service";
import { Transaction } from "../../models/transaction.model";

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent {

  product: Product | undefined;
  constructor(private router: Router, activatedRoute: ActivatedRoute,
              public productsService: ProductsService, public loginService: LoginService) {

    const id = activatedRoute.snapshot.params['id'];
    productsService.getProduct(id).subscribe(

      product => this.product = product,
      error => console.error(error)
    );
  }

  newTransation() {


  }

  cancel() {

    window.history.back();
  }
}
