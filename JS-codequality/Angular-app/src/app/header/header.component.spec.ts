import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HeaderComponent } from './header.component';
import { CommonModule } from '@angular/common';
describe('HeaderComponent', () => {
    let component: HeaderComponent;
    let element: HTMLElement;
    let fixture: ComponentFixture<HeaderComponent>;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [CommonModule],
        providers: [],
        declarations: [HeaderComponent],
      }).compileComponents();
  
      fixture = TestBed.createComponent(HeaderComponent);
      component = fixture.componentInstance;
      element = fixture.nativeElement;
    });
  
    it('should create', () => {
      expect(component).toBeTruthy();
    });
  
    it('should create', () => {
      const title = 'Users';
      const titleElement = element.querySelector('.header-title');
      component.title = title;
      fixture.detectChanges(); 
      expect(titleElement.textContent).toContain(title);
    });
  });