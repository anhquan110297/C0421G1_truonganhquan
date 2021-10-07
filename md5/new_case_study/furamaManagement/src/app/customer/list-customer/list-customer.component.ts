import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../icustomer";
import {ICustomerType} from "../icustomer-type";
import {CustomerServiceService} from "../customer-service.service";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customerList : ICustomer[];
  constructor(private customerService : CustomerServiceService) {
    customerService.findAllCustomer().subscribe( next => {
      this.customerList = next;
      console.log(this.customerList)
    });
  }

  ngOnInit(): void {
  }

}
