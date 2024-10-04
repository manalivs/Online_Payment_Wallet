import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Customer } from '../createAccount/customer';
import { CustomerService } from '../customer.service';
//import {Transaction} from './transaction';

@Component({

    selector: 'app-wallet',
    templateUrl :'./wallet.component.html',
    styleUrls : ['./wallet.component.css']
               

})

export class WalletPageComponent implements OnInit{
    
    c= sessionStorage.getItem('cust');
    cust1: Customer = new Customer(null,null,'','','','');
    constructor(private router: Router, private dataRoute: ActivatedRoute,
         private _custService: CustomerService) {

     }

    ngOnInit(){
        console.log(this.c);
         this._custService.getCustomerByUid(this.c)
        .subscribe(data => {
          console.log(data);
          this.cust1 = data;
          console.log(this.cust1);
        });
        console.log("hii");
        console.log(this.cust1);
        this.router.navigate(['/wallet_page/accountDetails_page']);

        
        
        

    }
    
}