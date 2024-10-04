import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
import {Customer} from 'src/app/createAccount/customer';
import {Transaction_Details} from 'src/app/transaction_details';
import { TransactionService } from 'src/app/transaction.service';
import { ExceptionResponse} from 'src/app/exception_response';

@Component({

    selector: 'app-fund_transfer',
    templateUrl :'./fund_transfer.component.html',
    styleUrls : ['./fund_transfer.component.css']
               

})

export class FundTransferComponent implements OnInit{
    password='';
    phnNo=null;
    c= sessionStorage.getItem('cust');
    cust1: Customer = new Customer(null,null,'','','','');
    transactionModel: Transaction_Details=new Transaction_Details();
    msg: ExceptionResponse= new ExceptionResponse('');

    constructor(private router: Router,private dataRoute: ActivatedRoute,
        private _custService: CustomerService, private _transService: TransactionService) {
                
    }
    onSubmit(){
            this._custService.validate(this.phnNo).subscribe(data =>{
                this.msg =data;
                console.log(data);
                if(this.msg.errorMessage == "Customer Validated."){
                    this.check();
                }
                else{
                    alert(this.msg.errorMessage);
                    this.router.navigate(['/wallet_page/fundTransfer_page']);
                }

            });
    }
    check(){
        this._transService.checkPassword(this.c, this.password).subscribe(data=>{
            this.msg = data;
            if(this.msg.errorMessage == "Correct Password."){
                this.fundTransfer();
            }
            else{
                alert(this.msg.errorMessage);
                this.router.navigate(['/wallet_page/fundTransfer_page']);
            }

        });
    }

    fundTransfer(){
        this.transactionModel.payee=this.c;
        this.transactionModel.recipient=this.phnNo+"@WalletApp";
        this.transactionModel.transaction_date = new Date();
        this.transactionModel.transaction_time = new Date();
        this._transService.fundTransfer(this.transactionModel).subscribe(data => {
           console.log(data);
           this.msg = data;
           alert(this.msg.errorMessage)
           if(this.msg.errorMessage == "Payment Successsful."){
            this.router.navigate(['/wallet_page']);
           }
           else
           {
            this.router.navigate(['/wallet_page/fundTransfer_page']);
           }
        });
    }

    ngOnInit(){

    }
    
}