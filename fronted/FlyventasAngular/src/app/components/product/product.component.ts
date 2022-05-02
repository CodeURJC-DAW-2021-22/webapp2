import { Component } from '@angular/core';
import { Product } from "../../models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import { LoginService } from "../../services/login.service";
import { ProductService } from "../../services/product.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls:["../../../assets/css/product.css"]
})
export class ProductComponent {

  product: Product | undefined;
  constructor(private router: Router, activatedRoute: ActivatedRoute,
              public productService: ProductService, public loginService: LoginService) {

    const id = activatedRoute.snapshot.params['id'];
    productService.getProduct(id).subscribe({

      next: product => this.product = product,
      error: error => console.error(error)
    });
  }

  cancel() {
    window.history.back();
  }
}
