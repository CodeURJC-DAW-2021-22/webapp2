import {Component, ViewChild} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'
import { ProductService } from "../../services/product.service";
import { Product } from "../../models/product.model";
import {LoginService} from "../../services/login.service";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-upload-product',
  templateUrl: './upload-product.component.html'
})
export class UploadProductComponent {

  SelectedCategory! : string;

  @ViewChild("file")
  file: any;
  user: User;

  constructor( private router: Router, activatedRoute: ActivatedRoute, public productService: ProductService,
               public loginService: LoginService, public userService: UserService) {

    this.userService.getUserLogged().subscribe({

        next: response => this.user = response,
        error: error => this.router.navigate(['/login'])
      }
    )

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
      user: this.user
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

  cancel() {
    window.history.back();
  }
}
