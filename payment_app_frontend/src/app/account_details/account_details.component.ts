import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import {Customer} from 'src/app/createAccount/customer';
import { Router } from '@angular/router';
import { ExceptionResponse} from 'src/app/exception_response';

@Component({

    selector: 'app-account',
    templateUrl : './account_details.component.html',
    styles : [`

    {
        box-sizing: border-box;
      }
      
      .column {
        float: left;
        width: 50%;
        padding: 5px;
      }
      
      /* Clearfix (clear floats) */
      .row::after {
        content: "";
        clear: both;
        display: table;
      }
    
    `]
    // ['./account_details.component.css']

               

})

export class AccountDetailsComponent implements OnInit{
    c= sessionStorage.getItem('cust');
    customer: Customer = new Customer(null,null,'','','','');
    msg: ExceptionResponse= new ExceptionResponse('');

    constructor(private router: Router, private _custService: CustomerService) {

    }
    ngOnInit(){
        this._custService.getCustomerByUid(this.c)
        .subscribe(data => {
          console.log(data);
          this.customer = data;
        });

    }
    delete(){
      if(confirm("Are you sure to delete this account")) {
        this._custService.deleteAccount(this.c).subscribe(data=>{
          this.msg = data;
          alert(this.msg.errorMessage);
          this.router.navigate(['/wallet_page/logout_page']);

        })
      }
    }
    
}