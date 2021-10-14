import { TestBed } from '@angular/core/testing';

import { CarStationServiceService } from './car-station-service.service';

describe('CarStationServiceService', () => {
  let service: CarStationServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarStationServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
