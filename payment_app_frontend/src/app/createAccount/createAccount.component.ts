import { Component, OnInit } from '@angular/core';
import {Customer} from './customer';
import { CustomerService } from 'src/app/customer.service';
import { Router } from '@angular/router';
import { ExceptionResponse} from 'src/app/exception_response';


@Component({

    selector: 'app-createAcc',
    templateUrl : './createAccount.component.html',
    styles : [`
    
    .login-wrap{
        width:100%;
        margin:auto;
        max-width:400px;
        min-height:560px;
        position:relative;
        background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
        box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
    }
    .login-html{
        width:100%;
        height:100%;
        position:absolute;
        padding:10px 70px 30px 70px;
        background:rgba(21,27,84,.9);
    }
    .login-form .group{
        margin-bottom:10px;
    }
    .login-form .group .label,
    .login-form .group .input,
    .login-form .group .button{
        width:100%;
        color:#000000;
        display:block;
    }
    .login-form .group .button{
        border:none;
        padding:15px 20px;
        border-radius:25px;
        background:rgba(255,255,255,.1);
    }
    .login-form .group .label{
        color:#aaa;
        font-size:12px;
    }
    .hr{
        height:2px;
        margin:5px 0 10px 0;
        background:rgba(255,255,255,.2);
    }
    .login-form .group .button{
        background:#1161ee;
    }
    
    
    
    `]
})
export class CreateAccountComponent implements OnInit{
    
    customerModel: Customer = new Customer(null,null,'','','','');
    msg: ExceptionResponse= new ExceptionResponse('');

    constructor(private router: Router, private _custService: CustomerService){}

    onSubmit(){
        this.customerModel.balance=0;
        this.customerModel.upiId= this.customerModel.mobileNo+"@WalletApp";
        this._custService.createCustomer(this.customerModel).subscribe(data => {
            console.log(data);
            this.msg = data;
            alert(this.msg.errorMessage);
            if(this.msg.errorMessage == "Account Created Successfully..."){
                sessionStorage.setItem('cust', this.customerModel.upiId);
                this.router.navigate(['/wallet_page']);
            }
            else{
                this.router.navigate(['/register_page']);
            }
        });
        
    }
   

    ngOnInit(){

    }
}