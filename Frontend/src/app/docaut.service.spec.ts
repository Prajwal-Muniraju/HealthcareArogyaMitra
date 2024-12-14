import { TestBed } from '@angular/core/testing';

import { DocautService } from './docaut.service';

describe('DocautService', () => {
  let service: DocautService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocautService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
