import {Component, OnInit} from '@angular/core';
import {ICustomer} from "../icustomer";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerServiceService} from "../customer-service.service";
import {Router} from "@angular/router";
import {ICustomerType} from "../icustomer-type";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  customer: ICustomer
  customerType : ICustomerType | any;
  customerForm: FormGroup

  constructor(private customerService: CustomerServiceService, private router: Router) {
    this.customerForm = new FormGroup({
      code: new FormControl("",[Validators.required]),
      name: new FormControl("",[Validators.required]),
      birthday: new FormControl("",[Validators.required]),
      gender: new FormControl("Male",[Validators.required]),
      idCard: new FormControl("",[Validators.required]),
      phone: new FormControl("",[Validators.required]),
      email: new FormControl("",[Validators.required]),
      address: new FormControl("",[Validators.required]),
      customerType: new FormControl("",[Validators.required]),
    })
    console.log(this.customerForm.value.id)
    customerService.findAllCustomerType().subscribe( next => {
      this.customerType = next;
    });
  }

  ngOnInit(): void {
  }

  createCustomer() {
   console.log(this.customerForm.value.id);
   this.customerService.createCustomer(this.customerForm.value).subscribe(() => this.router.navigateByUrl("customer/list"))
  }
}
