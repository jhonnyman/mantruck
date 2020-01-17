import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {TruckService, Truck} from 'truckapiclient';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  
  datasource: Object[] = [];

  constructor(private truckService:TruckService, private router: Router, private snackBar: MatSnackBar) {
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
        this.snackBar.open('No trucks found', 'WARNING', {
          duration: 3000
        });
      });
  }

  updateTruck(id){
    this.router.navigate([`/edit/${id}`]);
  }

  createTruck(){
    this.router.navigate([`/create`]);
  }

  deleteTruck(id){
    this.truckService
      .deleteTruck(id)
      .subscribe(() => {
        this.snackBar.open('Truck deleted successfully', 'OK', {
          duration: 3000
        });
        this.fetchTrucks();
      }, error => {
        this.snackBar.open('Error deleting the truck', 'ERROR', {
          duration: 3000
        });
      });
  }

  navigateHome(){
    this.router.navigate([`/`]);
  }
}
