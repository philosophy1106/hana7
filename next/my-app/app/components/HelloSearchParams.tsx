'use client';

import { usePathname, useSearchParams } from 'next/navigation';
import { useRouter } from 'next/navigation';
import { useLayoutEffect, useState } from 'react';

export default function HelloSearchParms() {
  const [state, setState] = useState('');
  const sparams = useSearchParams();

  useLayoutEffect(() => {
    setState(sparams.get('q') ?? '');
  }, [sparams]);

  const router = useRouter();
  const pathname = usePathname();
  console.log('🚀 ~ HelloSearchParms ~ pathname:', pathname);

  const setSearchParams = () => {
    const urlParams = new URLSearchParams(sparams.toString());
    urlParams.set('q', `${new Date()}`); // q=****
    urlParams.set('r', `rrr`);
    router.push(`/hello?${urlParams.toString()}`);
  };

  return (
    <>
      <h1>This is Hello Layout: {state}</h1>
      <button onClick={setSearchParams}>SetParam</button>
    </>
  );
}
