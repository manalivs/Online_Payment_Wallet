import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { WelcomePageComponent } from './welcomePage/welcomePage.component';
import { LoginComponent } from './login/login.component';
import { CreateAccountComponent } from './createAccount/createAccount.component';
import {WalletPageComponent} from './wallet/wallet.component';
import {AddMoneyComponent} from './add-money/add-money.component';
import { FundTransferComponent} from './fund_transfer/fund_transfer.component';
import { PrintTransactionComponent} from './print_transaction/print_transaction.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule} from '@angular/forms';
import { CustomerService } from './customer.service';
import { TransactionService } from './transaction.service';
import {HttpClientModule} from '@angular/common/http';
import { LogoutComponent } from './logout/logout.component';
import { AccountDetailsComponent } from './account_details/account_details.component';
import { WithdrawAmountComponent } from './withdraw_amount/withdraw_amount.component';
import { ChangePasswordComponent } from './change_password/change_password.component';
import { FooterComponent } from './footer/footer.component';
import { DeleteAccountComponent } from './delete_account/delete_account.component';

@NgModule({
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule
        
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        WelcomePageComponent,
        CreateAccountComponent,
        WalletPageComponent,
        AccountDetailsComponent,
        AddMoneyComponent,
        FundTransferComponent,
        PrintTransactionComponent,
        LogoutComponent,
        WithdrawAmountComponent,
        ChangePasswordComponent,
        DeleteAccountComponent,
        FooterComponent
		],
    providers: [  CustomerService, TransactionService],
    bootstrap: [AppComponent]
})

export class AppModule { }