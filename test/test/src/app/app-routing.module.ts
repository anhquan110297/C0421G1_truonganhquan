import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EditComponentComponent} from "./edit-component/edit-component.component";


const routes: Routes = [
  {
    path: "edit",
    component: EditComponentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
