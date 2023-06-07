import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageDashboardContentComponent } from './manage-dashboardcontent.component';

describe('ManageDashboardContentComponent', () => {
  let component: ManageDashboardContentComponent;
  let fixture: ComponentFixture<ManageDashboardContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageDashboardContentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageDashboardContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
