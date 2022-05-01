import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {Counteroffer} from "../models/counteroffer.model";

const BASE_URL = '/api/transaction/';

@Injectable({ providedIn: 'root' })
export class CounterofferService {

  constructor(private httpClient: HttpClient) { }

  getCounteroffers(): Observable<Counteroffer[]> {
    return this.httpClient.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Counteroffer[]>;
  }

  getCounteroffer(id: number | string): Observable<Counteroffer> {
    return this.httpClient.get(BASE_URL + id).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Counteroffer>;
  }

  addCounteroffer(counteroffer: Counteroffer) {

    if (!counteroffer.id) {
      return this.httpClient.post(BASE_URL, counteroffer)
        .pipe(
          catchError(error => this.handleError(error))
        );
    } else {
      return this.httpClient.put(BASE_URL + counteroffer.id, counteroffer).pipe(
        catchError(error => this.handleError(error))
      );
    }
  }

  deleteCounteroffer(counteroffer: Counteroffer) {
    return this.httpClient.delete(BASE_URL + counteroffer.id).pipe(
      catchError(error => this.handleError(error))
    );
  }

  private handleError(error: any) {
    console.log("ERROR:");
    console.error(error);
    return throwError("Server error (" + error.status + "): " + error.text())
  }
}
