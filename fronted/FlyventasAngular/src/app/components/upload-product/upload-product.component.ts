import {Component, OnInit, ViewChild} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'
import { ProductService } from "../../services/product.service";
import { Product } from "../../models/product.model";

@Component({
  selector: 'app-upload-product',
  templateUrl: './upload-product.component.html'
})
export class UploadProductComponent implements OnInit {

  SelectedCategory! : string;
  ngOnInit(): void {
  }


  product!: Product;
  removeImage:boolean = false;

  @ViewChild("file")
  file: any;


  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private service: ProductService) {

  }

  save() {
    if(this.product.image && this.removeImage){
      this.product.image = false;
    }
    this.service.addProduct(this.product).subscribe({
      next: product =>this.uploadImage(product as Product),
      error: error => alert('Error creating new book: ' + error)
    });
    this.router.navigate([""]);
  }

  uploadImage(product: Product): void {

    const image = this.file.nativeElement.files[0];
    if (image) {
      let formData = new FormData();
      formData.append("imageFile", image);
      this.service.setProductImage(product, formData).subscribe({
        next: _ => this.afterUploadImage(product),
        error: error => alert('Error uploading product image: ' + error)
      });
    } else if(this.removeImage){
      this.service.deleteProductImage(product).subscribe({
        next: _ => this.afterUploadImage(product),
        error: error => alert('Error deleting product image: ' + error)
      });
    } else {
      this.afterUploadImage(product);
    }
  }

  private afterUploadImage(product: Product){
    this.router.navigate(['/books/', product.id]);
  }

  cancel() {
    window.history.back();
  }
}
