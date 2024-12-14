import { TestBed } from '@angular/core/testing';

import { AdminautService } from './adminaut.service';

describe('AdminautService', () => {
  let service: AdminautService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminautService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
