import { async, ComponentFixture, TestBed, getTestBed } from '@angular/core/testing';
import { AddUserComponent } from './add-user.component';
import {AppService} from './add-user.service';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';

 
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

