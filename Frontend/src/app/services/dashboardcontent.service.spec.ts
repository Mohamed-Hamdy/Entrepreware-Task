import { TestBed } from '@angular/core/testing';

import { DashboardContentService } from './dashboardcontent.service';

describe('DashboardContentService', () => {
  let service: DashboardContentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DashboardContentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
