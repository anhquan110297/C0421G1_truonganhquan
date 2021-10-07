import {ICustomerType} from "./icustomer-type";

export interface ICustomer {
  id: number;
  code: string;
  customerType: ICustomerType;
  name: string;
  birthday: string;
  gender: string;
  idCard: string;
  phone: string;
  email: string;
  address: string
}
