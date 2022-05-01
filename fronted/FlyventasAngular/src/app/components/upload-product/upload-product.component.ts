import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-upload-product',
  templateUrl: './upload-product.component.html'
})
export class UploadProductComponent implements OnInit {
  Category: String | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
