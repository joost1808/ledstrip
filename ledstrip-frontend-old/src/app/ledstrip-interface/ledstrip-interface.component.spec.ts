import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LedstripInterfaceComponent } from './ledstrip-interface.component';

describe('LedstripInterfaceComponent', () => {
  let component: LedstripInterfaceComponent;
  let fixture: ComponentFixture<LedstripInterfaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LedstripInterfaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LedstripInterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
