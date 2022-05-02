import {Component, OnInit, ViewChild} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'
import { ProductService } from "../../services/product.service";
import { Product } from "../../models/product.model";
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-upload-product',
  templateUrl: './upload-product.component.html',
  styleUrls:["../../../assets/css/profile.css"]
})
export class UploadProductComponent {

  SelectedCategory! : string;

  @ViewChild("file")
  file: any;

  constructor( private router: Router, activatedRoute: ActivatedRoute, public productService: ProductService,
               public loginService: LoginService) {

  }

  newProduct(title: string, description: string, productPrice: string) {
    var price: number = +productPrice
    const newProduct: Product ={
      title: title,
      description: description,
      category: "",
      price: price,
      isSold: false,
      image: false,
      user: this.loginService.currentUser(),
    }
    this.productService.addProduct(newProduct).subscribe(
      newProduct => {
        this.uploadImage(newProduct.id)
      }
    )
    this.router.navigate([""]);
  }

  uploadImage(id?: number): void {

    const image = this.file.nativeElement.files[0];
    if (image) {
      let formData = new FormData();
      formData.append("imageFile", image);
      this.productService.setProductImage(id, formData).subscribe({
        next: _ => this.router.navigate([""]),
        error: _error => this.router.navigate([""])
      });
    } else {
      this.router.navigate([""])
    }
  }

  private afterUploadImage(product: Product){
    this.router.navigate(['/books/', product.id]);
  }

  cancel() {
    window.history.back();
  }
}
