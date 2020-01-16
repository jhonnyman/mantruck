import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Truck, TruckService } from 'truckapiclient';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  id: String;
  truck: any = {};
  updateForm: FormGroup;
  colorsArray: String[] = ['red','blue','white'];
  segmentsArray: String[] = this.makeTruckSegments(Truck.SegmentsEnum);
  
  constructor(private truckService: TruckService, private router: Router, private route: ActivatedRoute, private snackBar: MatSnackBar, private fb: FormBuilder) {
    this.createForm();
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params.id;
      this.truckService.getTruckById(params.id).subscribe(res => {
        this.truck = res;
        this.updateForm.get('name').setValue(this.truck.name);
        this.updateForm.get('engineHP').setValue(this.truck.engineHP);
        this.updateForm.get('engineVolume').setValue(this.truck.engineVolume);
        this.updateForm.get('fuel').setValue(this.truck.fuel);
        this.updateForm.get('segments').setValue(this.truck.segments);
        this.updateForm.get('colors').setValue(this.truck.colors);
      })
    });
  }

  makeTruckSegments(segmentEnum){
    const segments = [];
    for(const key in segmentEnum){
      segments.push(segmentEnum[key]);
    }
    return segments;
  }

  createForm() {
    this.updateForm = this.fb.group({
      name: ['', Validators.required],
      engineHP: ['', Validators.required],
      engineVolume: ['', Validators.required],
      fuel: ['', Validators.required],
      segments: new FormControl(),
      colors: new FormControl()
    });
  }

  updateTruck(name, engineHP, engineVolume, fuel, segments, colors){
    const updatedTruck = {
      id: parseInt(this.id.toString()),
      name,
      engineHP,
      engineVolume,
      fuel,
      segments,
      colors
    }
    this.truckService.updateTruck(updatedTruck).subscribe(() => {
      this.snackBar.open('Truck updated successfully', 'OK', {
        duration: 3000
      });
      this.navigateToList();
    }, error => {
      this.snackBar.open('Error updating the truck', 'ERROR', {
        duration: 3000
      });
    });
  }

  navigateToList(){
    this.router.navigate([`/`]);
  }
}
