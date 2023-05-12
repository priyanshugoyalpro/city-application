import { Component , OnInit } from '@angular/core';
import { CityService } from 'src/app/services/city.service';
import { Observable } from 'rxjs';
import { City } from 'src/app/model/city';
import { CityPatch } from 'src/app/model/city-patch';

@Component({
  selector: 'city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css'],
})
export class CityComponent implements OnInit{

  cities$ : Observable<City[]> | undefined;;
  pageNum : number =0;
  pageSize : number =8;

  sizeOptions : number[] =[8,10,25,50,100] ;

  constructor (private cityService : CityService) {

  }

  ngOnInit(): void {
    this.getCities();
   }

   getCities()
  {
   this.cities$= this.cityService.getCityByPage(this.pageNum,this.pageSize);
  }

  search(keyword:string)
  {
    this.cities$=this.cityService.getCityByName(keyword);
  }

  clearSearch()
  {
   this.getCities();
  }

  updateCity(updatedCity: City) {
    const id = Number(updatedCity.id);
    const cityPatch: CityPatch = { name: updatedCity.name, url : updatedCity.url};

    this.cityService.updateCityInfo(cityPatch,id).subscribe(res=> {
      alert("Updated Successfully");
      this.getCities();
    },
    err=> {
      alert("Updated Failed")
    });
  }

}
