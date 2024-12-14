import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMedicationComponent } from './update-medication.component';

describe('UpdateMedicationComponent', () => {
  let component: UpdateMedicationComponent;
  let fixture: ComponentFixture<UpdateMedicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateMedicationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateMedicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
