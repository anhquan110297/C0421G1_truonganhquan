import { Component, OnInit } from '@angular/core';
import {CarType} from '../../models/car-type';
import {Garage} from '../../models/garage';
import {CarStation} from '../../models/car-station';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CarStationServiceService} from '../../service/car-station-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  carStation: CarStation;
  id: number;
  carTypeList: CarType[];
  garageList: Garage[];
  createForm = new FormGroup({
    carCode: new FormControl('', [Validators.required]),
    carType: new FormControl('', [Validators.required]),
    garage: new FormControl('', [Validators.required]),
    destination: new FormControl('', [Validators.required]),
    departure: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required,Validators.email]),
    phone: new FormControl('', [Validators.required,Validators.pattern(/^(090|093|097)[0-9]{7}$/)]),
    startTime: new FormControl('', [Validators.required]),
    endTime: new FormControl('', [Validators.required])
  })
  constructor(private carStationService: CarStationServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getGarage();
    this.getCarType();
  }

  getCarType() {
    return this.carStationService.findAllCarType().subscribe(list => {
      this.carTypeList = list;
    })
  }

  getGarage() {
    return this.carStationService.findAllGarage().subscribe(list => {
      this.garageList = list;
      this.getCarType();
    })
  }

  create() {
    const value = this.createForm.value;
    console.log(value);
    if (this.createForm.valid) {
      this.carStationService.create(value).subscribe(() => {
        this.router.navigateByUrl("car");
      })
    } else {
      alert("Form của bạn đang sai vui lòng kiểm tra lại!");
    }
  }


  validationMessage = {
    carType: [
      {type : 'required', message: 'Please chose car type.'},
    ],
    garage: [
      {type: 'required', message: 'Please chose car garage.'},
    ],
    destination: [
      {type: 'required', message: 'Please input destination.'},
    ],
    departure: [
      {type : 'required', message: 'Please input departure.'},
    ],
    phone: [
      {type : 'required', message: 'Please input phone number.'},
      {type : 'pattern', message: 'Phone number invalid.\n Ex: 090xxxxxxx or 093xxxxxxx.'},
    ],
    address: [
      {type : 'required', message: 'Please input phone number.'},
    ],

    email: [
      {type : 'required', message: 'Please input email.'},
      {type : 'email', message: 'Email invalid.'},
    ],
    startTime: [
      {type : 'required', message: 'Please input startTime and start time has format : HH/MM'},
    ],
    endTime: [
      {type : 'required', message: 'Please input startTime and end time has format : HH/MM'},
    ],
  };

}
