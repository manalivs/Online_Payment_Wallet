import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import {Customer} from 'src/app/createAccount/customer';
import { Router } from '@angular/router';
import { Login_Details } from 'src/app/login_details';
import { ExceptionResponse} from 'src/app/exception_response';

@Component({

    selector: 'app-root',
    templateUrl : './login.component.html',
    styles : [`

    .login-wrap{
         width:100%;
         margin:auto;
         max-width:400px;
         min-height:470px;
         position:relative;
         background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
         box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
     }
     .login-html{
         width:100%;
         height:100%;
         position:absolute;
         padding:40px 70px 50px 70px;
         background:rgba(21,27,84,.9);
     }
     .login-form .group{
         margin-bottom:15px;
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
         margin:20px 0 25px 0;
         background:rgba(255,255,255,.2);
     }
     .login-form .group .button{
         background:#1161ee;
     }
    `]
})

export class LoginComponent implements OnInit{
    customer: Customer = new Customer(null,null,'','','','');
    log1: Login_Details = new Login_Details(null, '');
    msg: ExceptionResponse= new ExceptionResponse('');
    uid;

    constructor(private router: Router, private _custService: CustomerService) {

    }

    onSubmit(){
        this._custService.getCustomer(this.log1).subscribe(data =>{
            console.log(data);
            this.msg = data;
            alert(this.msg.errorMessage);
            if(this.msg.errorMessage == "Login Successful..."){
                this.login();
            }
            else{
                this.router.navigate(['/login_page']);
            }

        });
    }
    login(){
        this.uid = this.log1.mobileNo+"@WalletApp";
        this._custService.getCustomerByUid(this.uid)
        .subscribe(data => {
          console.log(data);
          this.customer = data;
          sessionStorage.setItem('cust', this.customer.upiId);
            this.router.navigate(['/wallet_page']);
        });
    }

    ngOnInit(){

    }
    
}
