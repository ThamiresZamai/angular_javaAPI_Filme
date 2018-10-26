import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarFilmeComponent } from './listar-filme.component';

describe('ListarFilmeComponent', () => {
  let component: ListarFilmeComponent;
  let fixture: ComponentFixture<ListarFilmeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarFilmeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarFilmeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
