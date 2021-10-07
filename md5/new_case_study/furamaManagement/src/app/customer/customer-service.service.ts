import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICustomer} from "./icustomer";
import {ICustomerType} from "./icustomer-type";

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private api_url_customer = "http://localhost:3000/customers";

  constructor(private httpClient: HttpClient) {
  }

  findAllCustomer() :Observable<ICustomer[] | any> {
    return this.httpClient.get(this.api_url_customer);
  }

  findAllCustomerType () : Observable<ICustomerType> | any {
    return this.httpClient.get("  http://localhost:3000/customerType")
  }

  createCustomer(customer : ICustomer) : Observable<any> {
      return this.httpClient.post(this.api_url_customer, customer);
  }

}
