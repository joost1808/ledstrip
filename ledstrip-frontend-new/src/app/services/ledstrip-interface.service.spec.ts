import { TestBed } from '@angular/core/testing';

import { LedstripInterfaceService } from './ledstrip-interface.service';

describe('LedstripInterfaceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LedstripInterfaceService = TestBed.get(LedstripInterfaceService);
    expect(service).toBeTruthy();
  });
});
