import { Component } from '@angular/core';
import {Product} from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../../services/login.service";
import { ProductService } from "../../services/product.service";
import { Transaction } from "../../models/transaction.model";

@Component({
  selector: 'app-profile',
  templateUrl: '../home/home.component.html'
})
export class ProfileComponent {

  product: Product | undefined;
  constructor(private router: Router, activatedRoute: ActivatedRoute,
              public productsService: ProductService, public loginService: LoginService) {

    const id = activatedRoute.snapshot.params['id'];
    productsService.getProduct(id).subscribe({

      next: product => this.product = product,
      error: error => console.error(error)
    });
  }


  cancel() {

    window.history.back();
  }
}
