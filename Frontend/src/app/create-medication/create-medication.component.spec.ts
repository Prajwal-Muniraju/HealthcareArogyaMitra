import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMedicationComponent } from './create-medication.component';

describe('CreateMedicationComponent', () => {
  let component: CreateMedicationComponent;
  let fixture: ComponentFixture<CreateMedicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateMedicationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateMedicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
