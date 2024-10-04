import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class TransactionService {
    serviceUrl = "http://localhost:9092/PayWallet/api/transactions";
    serviceUrl1 = "http://localhost:9092/PayWallet/api/transfer";
    serviceUrl2 = "http://localhost:9092/PayWallet/api/withdraw";
    serviceUrl3 = "http://localhost:9092/PayWallet/api/check";

    constructor(private http: HttpClient) { }

      addMoney(transactionModel: Object): Observable<any> {
        return this.http.post(`${this.serviceUrl}`, transactionModel);
      }
      fundTransfer(transactionModel: Object): Observable<any> {
        return this.http.post(`${this.serviceUrl1}`, transactionModel);
      }
      getTransactions(uid: String): Observable<any> {
        return this.http.get(`${this.serviceUrl1}/${uid}`);
      }
      withdrawAmount(transactionModel: Object): Observable<any> {
        return this.http.post(`${this.serviceUrl2}`, transactionModel);
      }
      checkPassword(uid: String, pass: String): Observable<any>{
        return this.http.get(`${this.serviceUrl3}/${uid}/${pass}`)
      } 

    }