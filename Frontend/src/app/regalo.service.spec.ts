import { TestBed } from '@angular/core/testing';

import { RegaloService } from './regalo.service';

describe('RegaloService', () => {
  let service: RegaloService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegaloService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
