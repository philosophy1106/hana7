import { use } from 'react';
import { getFolders } from '@/lib/folder';
import ClientComponent from '@/components/ClientComponent';
import ServerComponent from '@/components/ServerComponent';

type Props = {
  searchParams: Promise<{ q: string }>;
};

export default function Hello({ searchParams }: Props) {
  const { q } = use(searchParams);
  console.log('🚀 ~ Hello ~ sp:', q);
  return (
    <>
      <h3 className='font-bold'>
        Hello Page<span className='text-red-500'>{q}</span>
        <div>{`${new Date()}`}</div>
      </h3>
      <ClientComponent name={'Hong'} fAction={getFolders}>
        <ServerComponent f={getFolders} />
      </ClientComponent>
    </>
  );
}
