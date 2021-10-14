import {Component, OnInit} from '@angular/core';
import {ICustomer} from "../icustomer";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerServiceService} from "../customer-service.service";
import {Router} from "@angular/router";
import {ICustomerType} from "../icustomer-type";
import {MatSnackBar} from "@angular/material/snack-bar";
import {SnackBarComponent} from "../snack-bar/snack-bar.component";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  customer: ICustomer
  customerType : ICustomerType | any;
  customerForm: FormGroup
  minDate: Date;

  constructor(private customerService: CustomerServiceService, private router: Router,private snackBar : MatSnackBar) {
    this.customerForm = new FormGroup({
      code: new FormControl("",[Validators.required,Validators.pattern(/^KH-[0-9]{4}$/)]),
      name: new FormControl("",[Validators.required,Validators.minLength(5)]),
      birthday: new FormControl("",[Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]),
      gender: new FormControl("Male",[Validators.required]),
      idCard: new FormControl("",[Validators.required, Validators.pattern(/^([0-9]{9}|[0-9]{12})$/)]),
      phone: new FormControl("",[Validators.required, Validators.pattern(/^(090|091|(\(84\)\+90)|(\(84\)\+91))[0-9]{7}$/)]),
      email: new FormControl("",[Validators.required,Validators.email]),
      address: new FormControl("",[Validators.required]),
      customerType: new FormControl("",[Validators.required]),
    })
    console.log(this.customerForm.value.id)
    this.minDate = new Date();
    customerService.findAllCustomerType().subscribe( next => {
      this.customerType = next;
    });
  }

  ngOnInit(): void {
  }

  createCustomer(customerName : string | any) {
    console.log(this.customerForm.value);
    if (this.customerForm.valid) {
      this.customerService.createCustomer(this.customerForm.value).subscribe(next => {
        this.router.navigateByUrl("customer/list");
        this.openSnackBar(customerName)
      })
    }
  }

  openSnackBar (customerName : string | null | any){
    console.log(customerName)
    this.snackBar.openFromComponent(SnackBarComponent, {data: {name : 'Create ' +customerName+' Success '} , duration : 4000})
  }

  validationMessage = {
    code: [
      {type : 'required', message: 'Not null'},
      {type : 'pattern', message: '(KH-XXXX) x is number'},
    ],
    name: [
      {type : 'required', message: 'Not null'},
      {type : 'minlength', message: 'length must be greater than 5'},
    ],
    gender: [
      {type : 'required', message: 'Not null'},
    ],
    idCard: [
      {type : 'required', message: 'Not null'},
      {type : 'pattern', message: 'Invalid, id card must contain 9 or 12 number'},
    ],
    phone: [
      {type : 'required', message: 'Not null'},
      {type : 'pattern', message: 'Invalid, 090xxxxxxx or 091xxxxxxx'},
    ],
    customerType: [
      {type : 'required', message: 'Not null'},
    ],
    birthday: [
      {type : 'required', message: 'Not null'},
      {type : 'pattern', message: 'invalid'},
    ],
    email: [
      {type : 'required', message: 'Not null'},
      {type : 'pattern', message: 'invalid'},
    ],
    address: [
      {type : 'required', message: 'Not null'},
    ],
  }
}
