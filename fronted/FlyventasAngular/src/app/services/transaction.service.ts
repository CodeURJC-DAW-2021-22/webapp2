import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Transaction } from '../models/transaction.model';

const BASE_URL = '/api/transaction/';

@Injectable({ providedIn: 'root' })
export class TransactionService {

  constructor(private httpClient: HttpClient) { }

  getTransactions(): Observable<Transaction[]> {
    return this.httpClient.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Transaction[]>;
  }

  getTransaction(id: number | string): Observable<Transaction> {
    return this.httpClient.get(BASE_URL + id).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Transaction>;
  }

  addTransaction(transaction: Transaction) {

    if (!transaction.id) {
      return this.httpClient.post(BASE_URL, transaction)
        .pipe(
          catchError(error => this.handleError(error))
        );
    } else {
      return this.httpClient.put(BASE_URL + transaction.id, transaction).pipe(
        catchError(error => this.handleError(error))
      );
    }
  }

  private handleError(error: any) {
    console.log("ERROR:");
    console.error(error);
    return throwError("Server error (" + error.status + "): " + error.text())
  }
}
