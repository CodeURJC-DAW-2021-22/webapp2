import {Component, OnInit} from '@angular/core';
import {Product} from './../../models/product.model';
import {Router, ActivatedRoute} from '@angular/router';
import {ProductService} from './../../services/product.service';

@Component({
  templateUrl: './search.component.html'
})

export class SearchComponent implements OnInit{


  product!: Product;
  txt!: string;
  pageN!: string;
  pag!:number;

  products!: Product[];
  constructor(private router: Router, private activatedRoute: ActivatedRoute, private service: ProductService) {

    //console.log(activatedRoute.snapshot.paramMap.get('txt','page'))

  }
  ngOnInit() {

    this.txt = this.activatedRoute.snapshot.params['txt'];
    this.pageN = this.activatedRoute.snapshot.params['page'];
    let page: number = +this.pageN;
    this.service.getProductsSearch(page,this.txt).subscribe({
      next: show => this.products = show,
      error: error => console.log(error)
    });
  }

  nextPage(){
    this.pag = +this.pageN;
    this.pag += this.pag;
  }
  previusPage(){
    this.pag = +this.pageN;
    if (this.pag!=1)
    {
      this.pag -= this.pag;
    }
  }

  productImage(id:number){
    return this.product.image? '/api/books/'+id+'/image' : '/assets/images/no_image.png'
  }

}
