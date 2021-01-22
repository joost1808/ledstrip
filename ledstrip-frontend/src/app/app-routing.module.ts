import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LedstripInterfaceComponent } from './ledstrip-interface/ledstrip-interface.component';


const routes: Routes = [
  {path: '', component: LedstripInterfaceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
