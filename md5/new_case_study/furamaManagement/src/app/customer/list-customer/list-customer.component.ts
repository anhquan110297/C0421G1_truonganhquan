import {Component, OnInit} from '@angular/core';
import {ICustomer} from "../icustomer";
import {CustomerServiceService} from "../customer-service.service";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customerList: ICustomer[];
  name: string | any;

  constructor(private customerService: CustomerServiceService) {

  }

  ngOnInit(): void {
    this.customerService.findAllCustomer().subscribe(next => {
      this.customerList = next;
      console.log(this.customerList)
    });
  }

  search() {
    if (this.name == "") {
      this.ngOnInit()
    } else {
      // this.customerList = this.customerList.filter()
    }
  }
}
