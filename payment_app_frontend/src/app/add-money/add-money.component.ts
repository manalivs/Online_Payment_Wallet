import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
import {Customer} from 'src/app/createAccount/customer';
import {Transaction_Details} from 'src/app/transaction_details';
import { TransactionService } from 'src/app/transaction.service';
import { ExceptionResponse} from 'src/app/exception_response';



@Component({

    selector: 'app-add_money',
    templateUrl :'./add-money.component.html',
    styleUrls : ['./add-money.component.css']
               

})

export class AddMoneyComponent implements OnInit{
    amount=null;
    password='';
    caption='';
    c= sessionStorage.getItem('cust');
    msg: ExceptionResponse= new ExceptionResponse('');
    cust1: Customer = new Customer(null,null,'','','','');
    transactionModel: Transaction_Details=new Transaction_Details();

    constructor(private router: Router,private dataRoute: ActivatedRoute,
        private _custService: CustomerService, private _transService: TransactionService) {
                
    }
    onSubmit(){
        this._transService.checkPassword(this.c, this.password).subscribe(data=>{
            this.msg = data;
            if(this.msg.errorMessage == "Correct Password."){
                this.addMoney();
            }
            else{
                alert(this.msg.errorMessage);
                this.router.navigate(['/wallet_page/addMoney_page']);
            }

        });
    }
    addMoney(){
        this.transactionModel.payee=this.c;
        this.transactionModel.recipient=this.c;
        this.transactionModel.transaction_date = new Date();
        this.transactionModel.transaction_time = new Date();
        this._transService.addMoney(this.transactionModel).subscribe(data => {
            this.msg = data;
            alert(this.msg.errorMessage);
            this.router.navigate(['/wallet_page']);

      });
    }
    ngOnInit(){}
}