import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { TestBed, async } from '@angular/core/testing';
import { HttpClient, HttpHeaders, HttpErrorResponse} from '@angular/common/http';
import { runInThisContext } from 'vm';
import { Router } from '@angular/router';
import {AppService} from './add-user.service';

const endpoint = 'http://localhost:5678/adduser';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};


@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  userform;
  temp;
  

  constructor(private http: HttpClient,private router:Router,public appService: AppService) { }

  ngOnInit() {

    this.userform = new FormGroup({

      firstname: new FormControl('',[Validators.required,Validators.maxLength(10)]),
      lastname: new FormControl('',[Validators.required,Validators.maxLength(15)]),
      age: new FormControl('',[Validators.required,Validators.maxLength(3),Validators.max(120),Validators.min(10)]),
      tel:new FormControl('',[Validators.required,Validators.maxLength(10)]),
    });
  }
  onSubmit(){
  // this.temp= JSON.parse(sessionStorage.getItem('users57'));
  // if(!this.temp)
  //   this.temp={};
  // this.temp[this.userform.value.tel]=this.userform.value;
  // sessionStorage.setItem('users57',JSON.stringify(this.temp));
   console.log(this.userform.value,"hello");
  //  var observable=this.http.post<any>(endpoint, this.userform.value, httpOptions);
  //  observable.subscribe();
  this.appService.postData(this.userform.value).subscribe();
   this.router.navigate['userlist'];
  }

}

