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


  products!: Product[];
  pag!: number;
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
    this.pag = +this.pageN;
  }



  reload(){
    this.router.navigate(['search/' + this.txt + '/' + this.pag]);
  }

  showProduct(){

    this.service.getProductsSearch(this.pag,this.txt).subscribe({
      next: show => this.products = show,
      error: error => console.log(error)
    });

  }
  nextPage(){

    this.pag = this.pag + 1;
    this.showProduct()
    this.reload()
  }
  previusPage(){

    if (this.pag!=0)
    {
      this.pag = this.pag -1;
      this.showProduct()
      this.reload()
    }
  }

  productImage(id:number){
    return 'https://localhost:8443/api/products/'+id+'/image';
  }

}
