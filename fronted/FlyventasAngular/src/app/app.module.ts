import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {RouterModule} from "@angular/router";
import { HeaderComponent } from './components/header/header.component';
import { CustomheaderComponent } from './components/customheader&footer/customheader.component';
import {CustomfooterComponent} from "./components/customheader&footer/customfooter.component";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CustomheaderComponent,
    CustomfooterComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
