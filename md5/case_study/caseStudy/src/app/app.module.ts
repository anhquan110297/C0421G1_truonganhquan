import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CustomerComponent } from './component/customer/customer.component';
import { EmployeeComponent } from './component/employee/employee.component';
import { ContractComponent } from './component/contract/contract.component';
import { ServiceComponent } from './component/service/service.component';
import { ContractDetailComponent } from './component/contract-detail/contract-detail.component';
import { CreateEmployeeComponent } from './component/employee/create-employee/create-employee.component';
import { EditEmployeeComponent } from './component/employee/edit-employee/edit-employee.component';
import { DeleteEmployeeComponent } from './component/employee/delete-employee/delete-employee.component';
import { CreateCustomerComponent } from './component/customer/create-customer/create-customer.component';
import { EditCustomerComponent } from './component/customer/edit-customer/edit-customer.component';
import { DeleteCustomerComponent } from './component/customer/delete-customer/delete-customer.component';
import { CreateServiceComponent } from './component/service/create-service/create-service.component';
import { EditServiceComponent } from './component/service/edit-service/edit-service.component';
import { DeleteServiceComponent } from './component/service/delete-service/delete-service.component';
import { ViewCustomerComponent } from './component/customer/view-customer/view-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    EmployeeComponent,
    ContractComponent,
    ServiceComponent,
    ContractDetailComponent,
    CreateEmployeeComponent,
    EditEmployeeComponent,
    DeleteEmployeeComponent,
    CreateCustomerComponent,
    EditCustomerComponent,
    DeleteCustomerComponent,
    CreateServiceComponent,
    EditServiceComponent,
    DeleteServiceComponent,
    ViewCustomerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
