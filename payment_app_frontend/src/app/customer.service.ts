import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Customer} from 'src/app/createAccount/customer';
//import 'rxjs/add/operator/catch';

@Injectable()
export class CustomerService {
    serviceUrl = "http://localhost:9092/PayWallet/api/customers";
    serviceUrl1 = "http://localhost:9092/PayWallet/api/cust";
    serviceUrl2 = "http://localhost:9092/PayWallet/api/getLogin";
    serviceUrl3 = "http://localhost:9092/PayWallet/api/change";
    serviceUrl4 = "http://localhost:9092/PayWallet/api/delete";

    //customer: Customer = new Customer(null,null,'','','','');
    constructor(private http: HttpClient) {
     }
    

    createCustomer(customerModel: Object): Observable<any> {
        return this.http.post(`${this.serviceUrl}`, customerModel);
      }
      getCustomer(Login_Details: Object): Observable<any> {
        return this.http.post(`${this.serviceUrl2}`,Login_Details);
      }
      getCustomerByUid(uid: String): Observable<any> {
        return this.http.get(`${this.serviceUrl1}/${uid}`);
      }
      isUserLoggedIn(){
        let user = sessionStorage.getItem('cust');
        return !(user===null);

      }
      validate(id: number): Observable<any>{
        return this.http.get(`${this.serviceUrl}/${id}`);
      }
      changePassword(Login_Details: Object): Observable<any>{
        return this.http.post(`${this.serviceUrl3}`,Login_Details);
      }
      deleteAccount(uid: String): Observable<any> {
        return this.http.get(`${this.serviceUrl4}/${uid}`);
      }
      
      
    }