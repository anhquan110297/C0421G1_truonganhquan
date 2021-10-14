import {Component, OnInit} from '@angular/core';
import {CarStation} from '../../models/car-station';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CarStationServiceService} from '../../service/car-station-service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import {CarType} from '../../models/car-type';
import {Garage} from '../../models/garage';
import {SnackBarComponent} from '../layout/snack-bar/snack-bar.component';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  carStation: CarStation;
  carStationId: number;
  carType: CarType[];
  garage: Garage[];
  carStationForm: FormGroup = new FormGroup({
    carCode: new FormControl('', [Validators.required]),
    carType: new FormControl('', [Validators.required]),
    garage: new FormControl('', [Validators.required]),
    destination: new FormControl('Male', [Validators.required]),
    departure: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required,Validators.email]),
    phone: new FormControl('', [Validators.required,Validators.pattern(/^(090|093|097)[0-9]{7}$/)]),
    startTime: new FormControl('', [Validators.required]),
    endTime: new FormControl('', [Validators.required]),
  });

  constructor(private carStationService: CarStationServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private snackBar: MatSnackBar) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.carStationService.findAllCarType().subscribe(next => {
        this.carType = next;
      });
      this.carStationService.findAllGarage().subscribe(next => {
        this.garage = next;
      });
      this.carStationId = Number(paramMap.get('id'));
      this.carStationService.findById(this.carStationId).subscribe(next => {
        this.carStation = next;
        this.carStationForm.setValue(next);
      });
    });
  }

  ngOnInit(): void {
  }


  editCustomer(code: string | any) {
    const value = this.carStationForm.value;
    console.log(value);
    console.log(this.carStationId);
    if (this.carStationForm.valid) {
      this.carStationService.editCustomer(this.carStationId, value).subscribe(next => {this.router.navigateByUrl('list');
      this.openSnackBar(code)});
    }
  }

  openSnackBar(code: string | any) {
    console.log(code);
    this.snackBar.openFromComponent(SnackBarComponent, {data: {name: 'Update ' + code + ' Success '}, duration: 4000});
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
