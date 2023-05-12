import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CityListComponent } from './city-list.component';

describe('CityItemComponent', () => {
  let component: CityListComponent;
  let fixture: ComponentFixture<CityListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CityListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CityListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
