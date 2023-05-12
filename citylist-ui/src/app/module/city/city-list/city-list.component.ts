import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { City } from 'src/app/model/city';

@Component({
  selector: 'city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit{
  @Input()city!: City;
  @Input() isUpdate: boolean = false;
  updateForm!: FormGroup;
  @Output() update = new EventEmitter();

  constructor(private formBuilder: FormBuilder){
  }

  ngOnInit(): void {
    this.updateForm = this.formBuilder.group({
      id: [this.city.id, [Validators.required]],
      name: [this.city.name, [Validators.required]],
      url: [this.city.url]
    });
  }

  setDefaultImg(){
    this.city.url = "assets/images/img-place-holder.png";
  }

  openEdit(){
    this.isUpdate = true;
  }

  closeUpdate(){
    this.isUpdate = false;
  }

  submitForm() {
    this.closeUpdate();
    const updatedCity: City = this.updateForm.getRawValue() as City;
    this.update.emit(updatedCity);
  }
}