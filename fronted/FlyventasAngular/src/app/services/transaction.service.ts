import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map, Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Transaction } from '../models/transaction.model';
import {Product} from "../models/product.model";

const BASE_URL = 'https://localhost:8443/api/transactions/';

@Injectable({ providedIn: 'root' })
export class TransactionService {

  constructor(private httpClient: HttpClient) { }

  getTransaction(id: number | string): Observable<Transaction>{
    return this.httpClient.get(BASE_URL + id).pipe(map(
      response => response as Transaction
    ))
  }

  getTransactions(): Observable<Transaction[]>{
    return this.httpClient.get(BASE_URL).pipe(map(
      response => response as Transaction[]
    ))
  }

  getTransactionsUserBuyer(id: number | string): Observable<Transaction[]>{
    return this.httpClient.get(BASE_URL +"userBuyer/"+ id).pipe(map(
      response => response as Transaction[]
    ))
  }

  getTransactionsUserSeller(id: number | string): Observable<Transaction[]>{
    return this.httpClient.get(BASE_URL +"userSeller/"+ id).pipe(map(
      response => response as Transaction[]
    ))
  }

  addTransaction(transaction: Transaction) {
    return this.httpClient.post(BASE_URL, transaction).pipe(map(
      response => response as Transaction
    ))
  }

  private handleError(error: any) {
    console.log("ERROR:");
    console.error(error);
    return throwError("Server error (" + error.status + "): " + error.text())
  }
}
