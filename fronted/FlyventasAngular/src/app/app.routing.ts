import { RouterModule } from '@angular/router';

import {TransactionComponent} from "./components/Transaction&Counteroffer/transaction.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";


const appRoutes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'search', component: SeachComponent },
  { path: 'profile/:id', component: ProfileComponent },
  { path: 'profile/:id/uploadProduct', component: UploadProductComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'product/:id', component: ProductComponent },
  { path: 'product/:id/transaction', component: TransactionComponent },
  { path: 'product/:id/counteroffer', component: CounterofferComponent }
]

export const routing = RouterModule.forRoot(appRoutes);
