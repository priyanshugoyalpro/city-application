import { Component  , OnInit} from '@angular/core';
import { CityService } from 'src/app/services/city.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public cities :any;

  constructor (private cityService : CityService)
  {

  }

  ngOnInit() {
      this.getCities();
  }

  getCities()
  {
    this.cityService.getCities().subscribe(
      data => { this.cities=data},
      err => console.error(err),
      () => console.log("cities loaded")

    );
  }



}
