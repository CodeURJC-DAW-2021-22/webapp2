import { Component } from '@angular/core';
import {Product} from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent {

  product: Product;
  constructor(private router: Router, activatedRoute: ActivatedRoute,
              public productsService: ProductsService, public loginService: Login) {

    const id = activatedRoute.snapshot.params['id'];
    productsService.getProduct(id).subscribe(

      product => this.product = product,
      error => console.error(error)
    );
  }

}
