import {CustomerType} from "./customer-type";

export interface Customer {
   id : number;
   name : string;
   birthday : string;
   idCard : string;
   gender : number;
   address : string;
   customerCode : string;
   customerType : CustomerType;
}
