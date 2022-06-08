import { TestBed } from '@angular/core/testing';

import { RecruteursService } from './recruteurs.service';

describe('RecruteursService', () => {
  let service: RecruteursService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecruteursService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
