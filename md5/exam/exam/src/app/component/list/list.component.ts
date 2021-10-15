import { Component, OnInit } from '@angular/core';
import {CarStationServiceService} from '../../service/car-station-service.service';
import {MatDialog} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import {CarStation} from '../../models/car-station';
import {RemoveComponent} from '../remove/remove.component';
import {SnackBarComponent} from '../layout/snack-bar/snack-bar.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  carStationList: CarStation[];
  carId : number;
  carCode: string;
  currentPage : number = 0;
  constructor(private carStationService : CarStationServiceService,private dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.carStationService.findAllCarStation(this.currentPage).subscribe(next => {
      this.carStationList = next.content;
      console.log(this.carStationList)
    });
  }

  openDialogDelete(id: number, code: any) {
    this.carId = Number(id);
    this.carCode = code;
    console.log(this.carId);
    // khai bao dialog mo tu component nao va truyen du lieu
    let dialogRef = this.dialog.open(RemoveComponent, {
      data: {name: this.carCode}
    });
    // sau khi dong dialog thi lam gi
    dialogRef.afterClosed().subscribe(next => {
      console.log(next)
      if (next == 'true') {
        this.carStationService.delete(this.carId).subscribe(next => this.ngOnInit(), this.openSnackBar(code));
      }
    });
  }


  openSnackBar(code: string | any) {
    console.log(code)
    this.snackBar.openFromComponent(SnackBarComponent, {
      data: {name: 'Delete ' + code + ' Success '},
      duration: 4000
    })
  }

  previousPage() {
    console.log(this.currentPage);
    if (this.currentPage > 0) {
      this.currentPage--;
      this.ngOnInit();
    }
  }

  nextPage() {
    console.log(this.currentPage);
    this.currentPage++;
    this.ngOnInit();
  }
}
