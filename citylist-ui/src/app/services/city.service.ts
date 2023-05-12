import { Injectable } from '@angular/core';

import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { City } from '../model/city';
import { CityPatch } from '../model/city-patch';
const httpOptions= {
  headers : new HttpHeaders({'Content-Type' : 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http:HttpClient) {

   }

   getCities()
   {
    return this.http.get('/server/api/v1/cities');
   }


   getCityById(id : number)
   {
    return this.http.get('/server/api/v1/cities/'+id);
   }

   getCityByName(name : string): Observable<City[]>
   {
    return this.http.get<City[]>('/server/api/v1/cities/name/'+name);
   }

   getCityByPage(page : number , size : number)  : Observable<City[]>
   {
    return this.http.get<City[]>('/server/api/v1/cities/page/'+page + '/' + size);
   }
 
   updateCityInfo(city :CityPatch, id : number) :Observable<City>
   {
    return this.http.patch<City>('/server/api/v1/cities/'+id,city,httpOptions);
   }



}
