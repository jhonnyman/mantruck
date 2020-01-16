import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
import { Truck, TruckService} from 'truckapiclient';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  createForm: FormGroup;
  colorsArray: String[] = ['red','blue','white'];
  segmentsArray: String[] = this.makeTruckSegments(Truck.SegmentsEnum);

  constructor(private truckService: TruckService, private fb: FormBuilder, private router: Router, private snackBar: MatSnackBar) {

    this.createForm = this.fb.group({
      name: ['', Validators.required],
      engineHP: ['', Validators.required],
      engineVolume: ['', Validators.required],
      fuel: new FormControl(),
      segments: new FormControl(),
      colors: new FormControl()
    });
  }

  onChangeColors(event){
    console.log(event);
  }

  makeTruckSegments(segmentEnum){
    const segments = [];
    for(const key in segmentEnum){
      segments.push(segmentEnum[key]);
    }
    return segments;
  }

  createTruck(name, engineHP, engineVolume, fuel, segments, colors) {
    const newTruck = {
      name,
      engineHP,
      engineVolume,
      fuel,
      segments,
      colors
    }
    this.truckService.addTruck(newTruck).subscribe(() => {
      this.snackBar.open('Truck created successfully', 'OK', {
        duration: 3000
      });
      this.router.navigate([`/list`]);
    }, error => {
      this.snackBar.open('Error creating the truck', 'ERROR', {
        duration: 3000
      });
    });
  }

  ngOnInit() {
  }

}
