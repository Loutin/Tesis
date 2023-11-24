import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BackPageComponent } from './back-page.component';

describe('BackPageComponent', () => {
  let component: BackPageComponent;
  let fixture: ComponentFixture<BackPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BackPageComponent]
    });
    fixture = TestBed.createComponent(BackPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
