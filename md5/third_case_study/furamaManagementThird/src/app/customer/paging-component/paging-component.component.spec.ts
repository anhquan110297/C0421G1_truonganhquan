import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PagingComponentComponent } from './paging-component.component';

describe('PagingComponentComponent', () => {
  let component: PagingComponentComponent;
  let fixture: ComponentFixture<PagingComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagingComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagingComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
