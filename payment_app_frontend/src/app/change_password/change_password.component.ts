import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
import {Customer} from 'src/app/createAccount/customer';
import {Transaction_Details} from 'src/app/transaction_details';
import { TransactionService } from 'src/app/transaction.service';
import { ExceptionResponse} from 'src/app/exception_response';
import { Login_Details } from 'src/app/login_details';



@Component({

    selector: 'app-change_password',
    templateUrl :'./change_password.component.html',
    styleUrls : ['./change_password.component.css']
               

})

export class ChangePasswordComponent implements OnInit{
    password='';
    newPassword='';
    c= sessionStorage.getItem('cust');
    cust1: Customer = new Customer(null,null,'','','','');
    transactionModel: Transaction_Details=new Transaction_Details();
    log1: Login_Details = new Login_Details(null, '');
    msg: ExceptionResponse= new ExceptionResponse('');

    constructor(private router: Router,private dataRoute: ActivatedRoute,
        private _custService: CustomerService, private _transService: TransactionService) {
                
    }
    onSubmit(){
        if(this.password == this.newPassword){
            this._custService.getCustomerByUid(this.c).subscribe(data =>{
                    this.cust1 = data;
                    this.log1.mobileNo = this.cust1.mobileNo;
                    this.log1.password = this.password;
                    console.log(this.log1);
                    this._custService.changePassword(this.log1).subscribe(data1=>{
                        this.msg = data1;
                        alert(this.msg.errorMessage);


                    });

            });
            this.router.navigate(['/wallet_page/accountDetails_page']);

        }
        else{
            alert("Password Mismatch!!!")
        }   
    }
    

    ngOnInit(){}

    
}

// this._custService.changePassword(this.c,this.password).subscribe(data=>{
//     this.msg = data;
//     alert(this.msg.errorMessage);
    
// });
// this.router.navigate(['/wallet_page/accountDetails_page']);