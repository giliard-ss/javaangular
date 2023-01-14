import { TestBed } from '@angular/core/testing';

import { LoginOffGuard } from './login-off.guard';

describe('LoginOffGuard', () => {
  let guard: LoginOffGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LoginOffGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
