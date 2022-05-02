import {Component, OnInit} from '@angular/core';
import {Product} from './../../models/product.model';
import { Router } from '@angular/router';
import { ProductService } from '../../services/product.service';

@Component({
  templateUrl: './search.component.html'
})

export class SearchComponent implements OnInit{

  products!: Product[];

  constructor(private router: Router, private service: ProductService) {}

  ngOnInit() {
    this.service.getProducts().subscribe({
      next: products => this.products = products,
      error: error => console.log(error)
  });
  }

}
