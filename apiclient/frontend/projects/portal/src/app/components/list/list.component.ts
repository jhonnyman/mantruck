import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {TruckService, Truck} from 'truckapiclient';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  
  datasource: Object[] = [];

  constructor(private truckService:TruckService, private router: Router) {
  }
  
  ngOnInit(): void {
    this.fetchTrucks();
  }

  fetchTrucks(){
    this.truckService
      .listTruck()
      .subscribe((data: Truck[]) => {
        this.datasource = data;
      }, error => {
        console.log(error)
      });
  }

  updateTruck(id){
    this.router.navigate([`/edit/${id}`]);
  }

  createTruck(){
    this.router.navigate([`/create`]);
  }

  navigateHome(){
    this.router.navigate([`/`]);
  }
}
