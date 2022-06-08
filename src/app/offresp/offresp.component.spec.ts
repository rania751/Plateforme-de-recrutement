import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OffrespComponent } from './offresp.component';

describe('OffrespComponent', () => {
  let component: OffrespComponent;
  let fixture: ComponentFixture<OffrespComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OffrespComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OffrespComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
