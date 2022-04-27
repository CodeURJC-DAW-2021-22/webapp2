import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Product } from '../models/product.model';

const BASE_URL = '/api/product/';

@Injectable({ providedIn: 'root' })

export class ProductsServices  {

  constructor(private httpClient: HttpClient) {}

  getProducts(): Observable<Product[]>{
        return this.httpClient.get(BASE_URL).pipe(
            catchError(error => this.handleError(error))
        ) as Observable<Product[]>;
  }

  getProduct(id: number | string): Observable<Product>{
        return this.httpClient.get(BASE_URL + id).pipe(
            catchError(error => this.handleError(error))
        ) as Observable<Product>;
  }


  private handleError(error: any) {
    console.log("ERROR:");
    console.error(error);
    return throwError("Server error (" + error.status + "): " + error.text())
  }

  addProduct(product: Product) {

    if (!product.id) {
      return this.httpClient.post(BASE_URL, product)
        .pipe(
          catchError(error => this.handleError(error))
        );
    } else {
      return this.httpClient.put(BASE_URL + product.id, product).pipe(
        catchError(error => this.handleError(error))
      );
    }
  }

  setProductImage(product: Product, formData: FormData) {
    return this.httpClient.post(BASE_URL + product.id + '/image', formData)
      .pipe(
        catchError(error => this.handleError(error))
      );
  }

  deleteProductImage(product: Product) {
    return this.httpClient.delete(BASE_URL + product.id + '/image')
      .pipe(
        catchError(error => this.handleError(error))
      );
  }

  deleteProduct(product: Product) {
    return this.httpClient.delete(BASE_URL + product.id).pipe(
      catchError(error => this.handleError(error))
    );
  }

  updateProduct(product: Product) {
    return this.httpClient.put(BASE_URL + product.id, product).pipe(
      catchError(error => this.handleError(error))
    );
  }



}

