import { Component } from '@angular/core';
import {Product} from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../services/product.service";
import {LoginService} from "../../services/login.service";
import { Counteroffer } from "../../models/counteroffer.model";

@Component({
  selector: 'app-counteroffer',
  templateUrl: './counteroffer.component.html'
})
export class CounterofferComponent {

  product: Product | undefined;
  constructor(private router: Router, activatedRoute: ActivatedRoute,
              public productsService: ProductService, public loginService: LoginService) {

    const id = activatedRoute.snapshot.params['id'];
    productsService.getProduct(id).subscribe({

      next: product => this.product = product,
      error: error => console.error(error)
    });
  }

  newCounteroffer() {


  }

}
