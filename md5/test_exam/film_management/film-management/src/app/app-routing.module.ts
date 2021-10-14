import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListShowTimesComponent} from "./list-show-times/list-show-times.component";


const routes: Routes = [
  {path: "", component : ListShowTimesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
