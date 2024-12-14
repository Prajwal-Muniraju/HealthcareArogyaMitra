import { TestBed } from '@angular/core/testing';

import { AdminautguardService } from './adminautguard.service';

describe('AdminautguardService', () => {
  let service: AdminautguardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminautguardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
