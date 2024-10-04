import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Transaction_Details } from '../transaction_details';
import { TransactionService } from 'src/app/transaction.service';

@Component({

    selector: 'app-print_transaction',
    templateUrl :'./print_transaction.component.html',
    styleUrls : ['./print_transaction.component.css']
               

})

export class PrintTransactionComponent implements OnInit{
    transactions: Observable<Transaction_Details[]>;
    c= sessionStorage.getItem('cust');
   

    constructor(private router: Router, private dataRoute: ActivatedRoute,
         private _transService: TransactionService) {

    }

    ngOnInit(){
        this._transService.getTransactions(this.c).subscribe(data => {
            this.transactions=data;
            console.log(this.transactions);
        });
        
        

    }
    
}