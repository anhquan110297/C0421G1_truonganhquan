import {Component, OnInit} from '@angular/core';
import {Object} from "./object";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";

function comparePassword(check: AbstractControl) {
  const value = check.value;
  return (value.password === value.confirmPassword) ? null : {
    passwordNotMatch: true
  };
}

@Component({
  selector: 'app-register-form-component',
  templateUrl: './register-form-component.component.html',
  styleUrls: ['./register-form-component.component.css']
})
export class RegisterFormComponentComponent implements OnInit {
  object: Object;

  registerForm: FormGroup;

  countryList = [
    {id: 1, name: 'Viet Nam'},
    {id: 2, name: 'Canada'},
    {id: 3, name: 'USA'},
  ];

  constructor() {
    this.registerForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      passwordGroup: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)])
      }, {validators: comparePassword}),
      country: new FormControl('', Validators.required),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', Validators.required),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)])
    });
  }

  ngOnInit(): void {
  }



  onSubmit(){
    console.log(this.registerForm.value);
  }


}
