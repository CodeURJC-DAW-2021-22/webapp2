import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule} from "@angular/router";
import { HeaderComponent } from './components/header/header.component';
import { CustomheaderComponent } from './components/customheader&footer/customheader.component';
import { CustomfooterComponent} from "./components/customheader&footer/customfooter.component";
import { HomeComponent} from "./components/home/home.component";
import { LoginComponent} from "./components/login/login.component";
import { SearchComponent} from "./components/Busqueda/search.component";
import { UploadProductComponent } from './components/upload-product/upload-product.component';
import { TransactionComponent } from "./components/Transaction&Counteroffer/transaction.component";
import { CounterofferComponent } from "./components/Transaction&Counteroffer/counteroffer.component";
import { routing } from "./app.routing";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CustomheaderComponent,
    CustomfooterComponent,
    TransactionComponent,
    CounterofferComponent,
    HomeComponent,
    LoginComponent,
    SearchComponent,
    UploadProductComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    RouterModule,
    routing,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
