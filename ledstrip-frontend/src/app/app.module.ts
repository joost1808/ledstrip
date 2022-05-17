import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ColorPickerAllModule } from '@syncfusion/ej2-angular-inputs';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LedstripInterfaceComponent } from './ledstrip-interface/ledstrip-interface.component';
import { enableRipple } from '@syncfusion/ej2-base';

enableRipple(true)

@NgModule({
  imports: [
    BrowserModule,
    ColorPickerAllModule,
    RouterModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    LedstripInterfaceComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }