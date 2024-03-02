import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpServiceService } from '../http-service.service';
import { Product } from '../Product';
import { Router } from '@angular/router';
import { Cart } from '../Cart';
import { customer } from '../Customer';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-user-product',
  templateUrl: './user-product.component.html',
  styleUrl: './user-product.component.css'
})

export class UserProductComponent {

  posts:any;
  constructor(private userService: UserServiceService,private router: Router){}
  cart1:Cart[]=new Array();
  ngOnInit(){ // called by default as our web page loaded in browser
    this.userService.getProduct().subscribe(
      (response)=>{this.posts=response; 
      //console.log(this.posts)
    },
      (error)=>{console.log(error)}
    );
  }
  qty:number=1;
  total:number=0;
  totalsum:number=0;
  addToCart(id:number,name:string,price:number){
    this.totalsum=0;
    this.cart1.push(new Cart(name,price,id,this.qty,price*this.qty));
    for(let i of this.cart1){
      console.log(price);
      this.totalsum +=i.total;
    
    }
  }

  cust = new customer("Vaishnavi",6456986595,"Pune",this.cart1);
  m:any;
  Placeholder(){
    this.userService.PlaceOrder(this.cust).subscribe(
      (response:string)=>{this.m=response;
        
        if(this.m.indexOf('Your Order has been placed successfullly')!=-1)
          {console.log(this.m);
          }
        else
        this.router.navigate(['/successful'])
        },
        (error)=>{console.log(error)},
     );    
  }


}
