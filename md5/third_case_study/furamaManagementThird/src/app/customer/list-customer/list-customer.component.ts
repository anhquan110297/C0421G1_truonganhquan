import {Component, OnInit} from '@angular/core';
import {ICustomer} from "../icustomer";
import {CustomerServiceService} from "../customer-service.service";
import {MatDialog} from "@angular/material/dialog";
import {DeleteCustomerComponent} from "../delete-customer/delete-customer.component";
import {MatSnackBar} from "@angular/material/snack-bar";
import {SnackBarComponent} from "../snack-bar/snack-bar.component";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customerList: ICustomer[];
  nameSearch: string | any;
  key: string = 'id';
  reverse: boolean = false;
  p: number = 1;
  customerId: number;
  customerName: any;

  constructor(private customerService: CustomerServiceService, private dialog: MatDialog, private snackBar: MatSnackBar) {

  }

  ngOnInit(): void {
    this.customerService.findAllCustomer().subscribe(next => {
      this.customerList = next;
      console.log(this.customerList)
    });
  }

  // search method
  search() {
    if (this.nameSearch == "") {
      this.ngOnInit()
    } else {
      this.customerList = this.customerList.filter(res => {
        return res.name.toLocaleLowerCase().match(this.nameSearch.toLocaleLowerCase())
      })
    }
  }

  // sort method
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }


  openDialogDelete(customerId: string, customerName: any) {
    this.customerId = Number(customerId);
    this.customerName = customerName;
    console.log(this.customerId);
    // khai bao dialog mo tu component nao va truyen du lieu
    let dialogRef = this.dialog.open(DeleteCustomerComponent, {
      data: {name: this.customerName}
    });
    // sau khi dong dialog thi lam gi
    dialogRef.afterClosed().subscribe(next => {
      console.log(next)
      if (next == 'true') {
        this.customerService.delete(this.customerId).subscribe(next => this.ngOnInit(), this.openSnackBar(customerName));
      }
    });
  }

  openSnackBar(customerName: string | any) {
    console.log(customerName)
    this.snackBar.openFromComponent(SnackBarComponent, {
      data: {name: 'Delete ' + customerName + ' Success '},
      duration: 4000
    })
  }
}
