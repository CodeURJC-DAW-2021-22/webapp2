import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map, Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Product } from '../models/product.model';
import {User} from "../models/user.model";

const BASE_URL = 'api/products/';

@Injectable({ providedIn: 'root' })

export class ProductService {

  constructor(private httpClient: HttpClient) {}

  getProduct(id: number | string): Observable<Product>{
    return this.httpClient.get(BASE_URL + id).pipe(map(
      response => response as Product
    ))
  }

  getProducts(): Observable<Product[]>{
    return this.httpClient.get(BASE_URL).pipe(map(
      response => response as Product[]
    ))
  }

  getProductsSearch(page: number, txt: string): Observable<Product[]>{
    return this.httpClient.get(BASE_URL + "?title=" + txt + "&page=" + page).pipe(map(
      response => response as Product[],

    ))
  }

  getProductUser(id: number | string): Observable<Product[]>{
    return this.httpClient.get(BASE_URL +"user/"+ id).pipe(map(
      response => response as Product[]
    ))
  }

  addProduct(product: Product) {
    return this.httpClient.post(BASE_URL, product).pipe(map(
      response => response as Product
    ))
  }

  deleteProduct(product: Product) {
    return this.httpClient.delete(BASE_URL + product.id).pipe(map(
      response => response
    ))
  }

  updateProduct(product: Product) {
    return this.httpClient.put(BASE_URL + product.id, product).pipe(map(
      response => response
      ))
  }

  setProductImage(id?: number, formData?: FormData) {
    return this.httpClient.post(BASE_URL + id + '/image', formData).pipe(map(
      response => response
      ))
  }

  private handleError(error: any) {
    console.log("ERROR:");
    console.error(error);
    return throwError("Server error (" + error.status + "): " + error.text())
  }



}

