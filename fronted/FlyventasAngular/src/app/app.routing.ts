import { RouterModule } from '@angular/router';

import {TransactionComponent} from "./components/transaction&counteroffer/transaction.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {HomeComponent} from "./components/home/home.component";
import { SearchComponent } from "./components/search/search.component";
import { UploadProductComponent } from "./components/upload-product/upload-product.component";
import {CounterofferComponent} from "./components/transaction&counteroffer/counteroffer.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {ProductComponent} from "./components/product/product.component";


const appRoutes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'search/:txt/:page', component: SearchComponent },
  { path: 'profile/:id', component: ProfileComponent },
  { path: 'profile/:id/uploadProduct', component: UploadProductComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'product/:id', component: ProductComponent },
  { path: 'product/:id/transaction', component: TransactionComponent },
  { path: 'product/:id/counteroffer', component: CounterofferComponent }
]

export const routing = RouterModule.forRoot(appRoutes);
