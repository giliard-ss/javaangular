import { TestBed } from '@angular/core/testing';

import { LoginOnGuard } from './login-on.guard';

describe('LoginOnGuard', () => {
  let guard: LoginOnGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LoginOnGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
