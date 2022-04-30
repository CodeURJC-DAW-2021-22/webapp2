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






}
