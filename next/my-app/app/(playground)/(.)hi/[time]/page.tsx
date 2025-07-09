import { use } from 'react';

type Props = {
  params: Promise<{ time: string }>;
};

export default function Time({ params }: Props) {
  const { time } = use(params);
  return (
    <>
      Intercepting <span className='capitalize'>{time}</span> ~
    </>
  );
}
