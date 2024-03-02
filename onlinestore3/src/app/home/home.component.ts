import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpServiceService } from '../http-service.service';
import { Product } from '../Product';
import { Router } from '@angular/router';
import { Cart } from '../Cart';
import { login } from '../Login';
import { UserServiceService } from '../user-service.service';
import { elementAt } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  posts:any;
  constructor(private userService: UserServiceService,private router: Router){}
  

model=new login('','');
//posts:any;
userlogin(){
  this.userService.userlogin(this.model).subscribe(
    (response:string)=>{this.posts=response;
      console.log(this.posts);
    if(this.posts=="you are welcome")
      this.router.navigate(['./user-product']);
      else
        alert(this.posts);
  }
  );
}
usersignup() {
  let newemailid = <HTMLInputElement>document.getElementById("email")
  let newpassword = <HTMLInputElement>document.getElementById("password")
  if (newemailid && newemailid.value === "") {
    alert("Enter email id"); 
    return;
  }else if (newpassword && newpassword.value === "") {
    alert("enter password")
    return
  }else{
  this.userService.usersignup(this.model).subscribe(
    (response: string) => {
      this.posts = response;
      alert(this.posts);
    },
    error => console.log(error)
  );
  }
}


//adminUser:string=admin;
//adminPassword:string=admin123;
adminlogin(){
  this.router.navigate(['./admin-product']);
}
}
