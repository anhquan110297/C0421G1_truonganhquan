import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../icustomer";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerServiceService} from "../customer-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ICustomerType} from "../icustomer-type";
import {SnackBarComponent} from "../snack-bar/snack-bar.component";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customer : ICustomer | any;
  customerId : number;
  customerForm : FormGroup = new FormGroup({
    code: new FormControl("",[Validators.required]),
    name: new FormControl("",[Validators.required]),
    birthday: new FormControl("",[Validators.required]),
    gender: new FormControl("Male",[Validators.required]),
    idCard: new FormControl("",[Validators.required]),
    phone: new FormControl("",[Validators.required]),
    email: new FormControl("",[Validators.required]),
    address: new FormControl("",[Validators.required]),
    customerType: new FormControl("",[Validators.required]),
  });
  customerType : ICustomerType | any;

  constructor(private customerService: CustomerServiceService,
              private router : Router,
              private activatedRoute: ActivatedRoute,
              private snackBar : MatSnackBar) {
    this.activatedRoute.paramMap.subscribe((paramMap : ParamMap) => {
      customerService.findAllCustomerType().subscribe( next => {
        this.customerType = next;
      });
      this.customerId = Number(paramMap.get('id'));
      this.customerService.findById(this.customerId).subscribe( next => {
        this.customer = next;
        this.customerForm.setValue(next);
      });
    });
  };

  ngOnInit(): void {
  }

  editCustomer() {
    const value = this.customerForm.value;
    console.log(value);
    console.log(this.customerId);
    this.customerService.editCustomer(this.customerId,value).subscribe( next => this.router.navigateByUrl("customer/list"))
  }

  openSnackBar (customerName : string | any){
    console.log(customerName)
    this.snackBar.openFromComponent(SnackBarComponent, {data: {name : 'Update ' +customerName+' Success '} , duration : 4000})
  }

}
