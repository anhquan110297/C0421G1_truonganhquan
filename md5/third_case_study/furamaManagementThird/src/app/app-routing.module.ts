import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {CreateCustomerComponent} from "./customer/create-customer/create-customer.component";
import {EditCustomerComponent} from "./customer/edit-customer/edit-customer.component";


const routes: Routes = [
  {path: "",component : ListCustomerComponent},
  {path: "customer/list",component : ListCustomerComponent},
  {path: "customer/create" ,component : CreateCustomerComponent},
  {path: "customer/edit/:id" ,component : EditCustomerComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
