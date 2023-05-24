import dayjs from 'dayjs/esm';
import { ITopic } from 'app/entities/topic/topic.model';
import { IUser } from 'app/entities/user/user.model';

export interface IMessage {
  id: number;
  subject?: string | null;
  content?: string | null;
  postDate?: dayjs.Dayjs | null;
  topic?: Pick<ITopic, 'id'> | null;
  user?: Pick<IUser, 'id' | 'login'> | null;
  message?: Pick<IMessage, 'id'> | null;
}

export type NewMessage = Omit<IMessage, 'id'> & { id: null };
