import {CarType} from './car-type';
import {Garage} from './garage';

export interface CarStation {
  carCode : number;
  carType : CarType;
  garage : Garage;
  destination : string;
  departure : string;
  email : string;
  phone : string;
  startTime : string;
  endTime : string;
  id : number
}
