import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {SearchComponent} from "./components/Busqueda/search.component";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RegisterComponent} from "./components/register/register.component";
import {LoginComponent} from "./components/login/login.component";


@NgModule({
  declarations: [
    AppComponent, SearchComponent, RegisterComponent,LoginComponent
  ],
  imports: [BrowserModule, NgbModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
