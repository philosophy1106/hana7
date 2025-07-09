import { use } from 'react';

type Props = {
  params: Promise<{ time: string }>;
};

const Times = ['Morning', 'Afternoon', 'Evening', 'Night'];
export async function generateStaticParams() {
  return Times.map((time) => ({ time }));
}

export default function Time({ params }: Props) {
  const { time } = use(params);
  return (
    <>
      Good <span className='capitalize'>{time}</span>
    </>
  );
  // const [firstChar, ...timeStr] = time;
  // return <>Good {`${firstChar.toUpperCase()}${timeStr.join('')}`} ~</>;
}
