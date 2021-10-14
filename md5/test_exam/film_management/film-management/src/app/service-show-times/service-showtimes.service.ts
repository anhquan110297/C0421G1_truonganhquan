import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ShowTime} from "../model/show-time";

@Injectable({
  providedIn: 'root'
})
export class ServiceShowtimesService {

  constructor(private httpClient : HttpClient) { }

  private api_url_show_times = "http://localhost:3000/showtime";

  findAllShowTimes() : Observable<ShowTime | any>{
    return this.httpClient.get(this.api_url_show_times)
  }
  findAllMovieName() : Observable<ShowTime | any>{
    return this.httpClient.get(this.api_url_show_times)
  }

  delete(id: number): Observable<ShowTime> | any {
    return this.httpClient.delete(this.api_url_show_times + '/' + id);
  }

  createCustomer(showTime: ShowTime): Observable<any> {
    return this.httpClient.post(this.api_url_show_times, showTime);
  }
}
