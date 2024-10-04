import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';


@Component({
    selector: 'app',
    templateUrl: 'app.component.html',
    styles : [`
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, Helvetica, sans-serif;
        height: 100%;
        
      }
      
      .topnav {
        overflow: hidden;
        background-color: #151B54;
      }
      
      .topnav a {
        float: left;
        color: #f2f2f2;
        text-align: center;
        padding: 20px 16px 20px;
        text-decoration: none;
        font-size: 17px;
      }
      
      .topnav a:hover {
        background-color: #ddd;
        color: black;
      }
      
      .topnav-right {
        float: right;
      }
    `]
})

export class AppComponent {
    
    constructor(private router: Router, private _custService: CustomerService) {
    }
  
}