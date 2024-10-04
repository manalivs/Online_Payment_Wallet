import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomePageComponent } from './welcomePage/welcomePage.component';
import { LoginComponent } from './login/login.component';
import { CreateAccountComponent } from './createAccount/createAccount.component';
import { WalletPageComponent} from './wallet/wallet.component';
import {AddMoneyComponent} from './add-money/add-money.component';
import { FundTransferComponent} from './fund_transfer/fund_transfer.component';
import { PrintTransactionComponent} from './print_transaction/print_transaction.component';
import { LogoutComponent } from './logout/logout.component';
import { AccountDetailsComponent } from './account_details/account_details.component';
import { GaurdService } from 'src/app/guard.service';
import { WithdrawAmountComponent } from './withdraw_amount/withdraw_amount.component';
import { ChangePasswordComponent } from './change_password/change_password.component';
import { DeleteAccountComponent } from './delete_account/delete_account.component';

const routes: Routes = [
    { path: 'welcome_page', component: WelcomePageComponent },
    { path: 'login_page', component: LoginComponent },
    { path: 'register_page', component: CreateAccountComponent },
    { path: 'wallet_page', component: WalletPageComponent, canActivate:[GaurdService],
      children: [
        { path: 'accountDetails_page', component: AccountDetailsComponent, canActivate:[GaurdService] },
        { path: 'addMoney_page', component: AddMoneyComponent, canActivate:[GaurdService] },
        { path: 'withdrawAmount_page', component: WithdrawAmountComponent, canActivate:[GaurdService] },
        { path: 'fundTransfer_page', component: FundTransferComponent, canActivate:[GaurdService] },
        { path: 'printTransaction_page', component: PrintTransactionComponent, canActivate:[GaurdService] },
        { path: 'changePassword_page', component: ChangePasswordComponent, canActivate:[GaurdService] },
        { path: 'deleteAccount_page', component: DeleteAccountComponent, canActivate:[GaurdService] },
        { path: 'logout_page', component: LogoutComponent, canActivate:[GaurdService] }
      ]
    }  
  ];
  

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
  export const routingComponents=[WelcomePageComponent,LoginComponent,CreateAccountComponent,
    WithdrawAmountComponent,ChangePasswordComponent, DeleteAccountComponent,
    WalletPageComponent, AddMoneyComponent, FundTransferComponent, PrintTransactionComponent ]
  