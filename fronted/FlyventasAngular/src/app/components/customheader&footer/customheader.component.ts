import { Component } from '@angular/core';
import { LoginService} from "../../services/login.service";

@Component({
  selector: 'app-customheader',
  templateUrl: './customheader.component.html',
  styleUrls: ['../../../assets/css/style.css']
})
export class CustomheaderComponent {

  constructor(public loginService: LoginService) {

  }
}
