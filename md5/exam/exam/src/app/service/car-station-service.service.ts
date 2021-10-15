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
  private api_url_car_station = "http://localhost:8080/api/car-station";
  private api_url_car_type = "http://localhost:8080/api/car-type";
  private api_url_car_garage = "  http://localhost:8080/api/garage";

  constructor(private httpClient: HttpClient) { }

  findAllCarStation(currentPage: number): Observable<CarStation[] | any> {
    return this.httpClient.get(this.api_url_car_station+'/list'+'/?page='+ currentPage);
  }
  findAllCarType(): Observable<CarType[] | any> {
    return this.httpClient.get(this.api_url_car_type+ '/list');
  }
  findAllGarage(): Observable<Garage[] | any> {
    return this.httpClient.get(this.api_url_car_garage+'/list');
  }

  findById(id: number): Observable<CarStation> | any {
    return this.httpClient.get(this.api_url_car_station + '/' + id)
  }

  editCustomer(id: number, carStation: CarStation): Observable<CarStation> | any {
    return this.httpClient.put(this.api_url_car_station + '/edit' + id, carStation)
  }

  delete(id: number): Observable<CarStation> | any {
    return this.httpClient.delete(this.api_url_car_station + '/remove/' + id);
  }


  create(newCar: CarStation): Observable<CarStation | any> {
    return this.httpClient.post(this.api_url_car_station + '/create', newCar)
  }
}
