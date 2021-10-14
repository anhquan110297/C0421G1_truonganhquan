import { Component, OnInit } from '@angular/core';
import {ServiceShowtimesService} from "../service-show-times/service-showtimes.service";
import {ShowTime} from "../model/show-time";
import {Movies} from "../model/movies";

@Component({
  selector: 'app-list-show-times',
  templateUrl: './list-show-times.component.html',
  styleUrls: ['./list-show-times.component.css']
})
export class ListShowTimesComponent implements OnInit {
showTimeList : ShowTime[];
movieList : Movies[]
p : number = 1;

  constructor(private service : ServiceShowtimesService) { }

  ngOnInit(): void {
    this.service.findAllShowTimes().subscribe(next => {
      this.showTimeList = next;
      console.log(next);
    });
  }

  sort(id: string) {

  }

  openDialogDelete(id: number, name: any) {

  }
}
