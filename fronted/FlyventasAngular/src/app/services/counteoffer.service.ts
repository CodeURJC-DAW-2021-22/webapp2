import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map, Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';
import {Counteroffer} from "../models/counteroffer.model";
import {Product} from "../models/product.model";

const BASE_URL = '/api/transaction/';

@Injectable({ providedIn: 'root' })
export class CounterofferService {

  constructor(private httpClient: HttpClient) { }

  getCounteroffer(id: number | string): Observable<Counteroffer>{
    return this.httpClient.get(BASE_URL + id).pipe(map(
      response => response as Counteroffer
    ))
  }

  getCounteroffers(): Observable<Counteroffer[]>{
    return this.httpClient.get(BASE_URL).pipe(map(
      response => response as Counteroffer[]
    ))
  }

  addCounteroffer(counteroffer: Counteroffer) {
    return this.httpClient.post(BASE_URL, counteroffer).pipe(map(
      response => response as Counteroffer
    ))
  }

  deleteCounteroffer(counteroffer: Counteroffer) {
    return this.httpClient.delete(BASE_URL + counteroffer.id).pipe(map(
      response => response
    ))
  }

  private handleError(error: any) {
    console.log("ERROR:");
    console.error(error);
    return throwError("Server error (" + error.status + "): " + error.text())
  }
}
