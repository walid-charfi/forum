import dayjs from 'dayjs/esm';

import { IMessage, NewMessage } from './message.model';

export const sampleWithRequiredData: IMessage = {
  id: 29027,
};

export const sampleWithPartialData: IMessage = {
  id: 21687,
  subject: 'generation CFP PNG',
  postDate: dayjs('2023-05-23'),
};

export const sampleWithFullData: IMessage = {
  id: 91158,
  subject: 'generating b',
  content: 'B2C projection',
  postDate: dayjs('2023-05-23'),
};

export const sampleWithNewData: NewMessage = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
