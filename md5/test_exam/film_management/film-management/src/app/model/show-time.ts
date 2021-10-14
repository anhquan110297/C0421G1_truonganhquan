import {Movies} from "./movies";

export interface ShowTime {
  id: number;
  showTimeCode: string;
  movieNameShow: Movies;
  showDate: string;
  ticketAmount;
}
