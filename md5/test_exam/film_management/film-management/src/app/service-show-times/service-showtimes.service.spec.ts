import { TestBed } from '@angular/core/testing';

import { ServiceShowtimesService } from './service-showtimes.service';

describe('ServiceShowtimesService', () => {
  let service: ServiceShowtimesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceShowtimesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
