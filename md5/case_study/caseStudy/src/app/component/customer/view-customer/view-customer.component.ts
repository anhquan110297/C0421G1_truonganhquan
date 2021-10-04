import { Component, OnInit } from '@angular/core';
import {Customer} from "../customer";
import {CustomerType} from "../customer-type";

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customerTypeList : CustomerType [] = [
    {id : 1, name : "Gold"},
    {id : 2, name : "Silver"},
    {id : 3, name : "Platinum"},
    {id : 4, name : "Diamond"},
  ]

  customerList : Customer [] = [
    {id : 1, name : "Nguyen Van A ", birthday : "2003-07-13", address : "Da Nang" , customerCode : "KH-1234", gender : 0 , idCard: "123456789", customerType : this.customerTypeList[0]},
    {id : 2, name : "Nguyen Van B ", birthday : "2003-07-14", address : "Da Nang" , customerCode : "KH-1212", gender : 1 , idCard: "123456789", customerType : this.customerTypeList[0]},
    {id : 3, name : "Nguyen Van C ", birthday : "2003-07-15", address : "Da Nang" , customerCode : "KH-2323", gender : 0 , idCard: "123456789", customerType : this.customerTypeList[0]},
    {id : 4, name : "Nguyen Van D ", birthday : "2003-07-16", address : "Da Nang" , customerCode : "KH-1321", gender : 1 , idCard: "123456789", customerType : this.customerTypeList[0]},
    {id : 5, name : "Nguyen Van E ", birthday : "2003-07-17", address : "Da Nang" , customerCode : "KH-5123", gender : 0 , idCard: "123456789", customerType : this.customerTypeList[0]},
  ]
  constructor() { }

  ngOnInit(): void {
  }
}
