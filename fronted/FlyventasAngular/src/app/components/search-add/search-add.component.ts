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

  txt!:string;
  page = 0;
  category = []

  reload(){
    this.router.navigate(['search/'+this.txt+'/'+this.page])
      .then(() => {
        window.location.reload();
      });
  }
  setTxt(t:string){
    this.txt = t;
    this.reload()
  }


}
