import { Agepipe } from 'src/app/user-list/user-list.component';
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {AppService} from './user-list.service';

describe('Agepipe', () => {
    it('create an instance', () => {
      const pipe = new Agepipe(); // * pipe instantiation
      expect(pipe).toBeTruthy();
    });
  
    it('append yrs to age', () => {
      // * arrange
      const pipe = new Agepipe();
      // * act
      const ret = pipe.transform('21');
      // * asser
      expect(ret).toBe('21yrs');
    });
  });
  
  
  describe('AppService', () => {
    let injector: TestBed;
    let service: AppService;
    let httpMock: HttpTestingController;
    
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        providers: [AppService]
      });
      injector = getTestBed();
      service = injector.get(AppService);
      httpMock = injector.get(HttpTestingController);
    });
  });
