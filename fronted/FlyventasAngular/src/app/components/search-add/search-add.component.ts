import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-add',
  templateUrl: './search-add.component.html',
  styleUrls: ['./search-add.component.css']
})
export class SearchAddComponent{

  constructor(private router: Router) {
    
  }

  txt = '';

  setTxt(txt:string){
    this.txt = txt;
  }
    
  

}
