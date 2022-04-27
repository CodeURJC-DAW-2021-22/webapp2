import { RouterModule } from '@angular/router';

import {TransactionComponent} from "./components/Transaction&Counteroffer/transaction.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {HomeComponent} from "./components/home/home.component";
import { SearchComponent } from "./components/Busqueda/search.component";
import { UploadProductComponent } from "./components/upload-product/upload-product.component";


const appRoutes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'search', component: SearchComponent },
  //{ path: 'profile/:id', component: ProfileComponent },
  { path: 'profile/:id/uploadProduct', component: UploadProductComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  //{ path: 'product/:id', component: ProductComponent },
  { path: 'product/:id/transaction', component: TransactionComponent },
  //{ path: 'product/:id/counteroffer', component: CounterofferComponent }
]

export const routing = RouterModule.forRoot(appRoutes);
