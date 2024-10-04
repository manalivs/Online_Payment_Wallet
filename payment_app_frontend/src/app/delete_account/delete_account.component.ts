import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import {Customer} from 'src/app/createAccount/customer';
import { Router } from '@angular/router';
import { ExceptionResponse} from 'src/app/exception_response';

@Component({

    selector: 'app-account',
    templateUrl : './delete_account.component.html',
    styleUrls : ['./delete_account.component.css']
               

})

export class DeleteAccountComponent implements OnInit{
    c= sessionStorage.getItem('cust');
    msg: ExceptionResponse= new ExceptionResponse('');

    constructor(private router: Router, private _custService: CustomerService) {

    }
    ngOnInit(){
        this._custService.deleteAccount(this.c)
        .subscribe(data => {
          this.msg = data;
          alert(this.msg.errorMessage);
          sessionStorage.removeItem('cust');
        this.router.navigate(['login_page']);
          
        });

    }
    
}