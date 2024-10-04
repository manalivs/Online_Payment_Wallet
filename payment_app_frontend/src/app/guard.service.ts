import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';

@Injectable({
  providedIn: 'root'
})
export class GaurdService implements CanActivate {

  constructor(private router: Router,
    private _custService: CustomerService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this._custService.isUserLoggedIn())
      return true;

    this.router.navigate(['login_page']);
    return false;
  }
}
