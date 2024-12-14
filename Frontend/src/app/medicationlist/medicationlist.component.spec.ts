import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicationlistComponent } from './medicationlist.component';

describe('MedicationlistComponent', () => {
  let component: MedicationlistComponent;
  let fixture: ComponentFixture<MedicationlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MedicationlistComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedicationlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
