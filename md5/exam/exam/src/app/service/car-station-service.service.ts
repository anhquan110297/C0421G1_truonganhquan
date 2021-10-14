import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CarStation} from '../models/car-station';
import {CarType} from '../models/car-type';
import {Garage} from '../models/garage';

@Injectable({
  providedIn: 'root'
})
export class CarStationServiceService {
  private api_url_car_station = "http://localhost:3000/carStation";
  private api_url_car_type = "http://localhost:3000/carType";
  private api_url_car_garage = "  http://localhost:3000/garage";

  constructor(private httpClient: HttpClient) { }

  findAllCarStation(): Observable<CarStation[] | any> {
    return this.httpClient.get(this.api_url_car_station);
  }
  findAllCarType(): Observable<CarType[] | any> {
    return this.httpClient.get(this.api_url_car_type);
  }
  findAllGarage(): Observable<Garage[] | any> {
    return this.httpClient.get(this.api_url_car_garage);
  }

  findById(id: number): Observable<CarStation> | any {
    return this.httpClient.get(this.api_url_car_station + '/' + id)
  }

  editCustomer(id: number, carStation: CarStation): Observable<CarStation> | any {
    return this.httpClient.put(this.api_url_car_station + '/' + id, carStation)
  }

  delete(id: number): Observable<CarStation> | any {
    return this.httpClient.delete(this.api_url_car_station + '/' + id);
  }


}
