'use client';

import { useEffect, useState } from 'react';
import { Button } from '@/components/ui/button';

export default function DtStr() {
  const [dtStr, setDtStr] = useState('');
  useEffect(() => setDtStr(new Date().toString()), []);

  return (
    <>
      <h3>{dtStr}</h3>
      <button onClick={() => alert(dtStr)} className='btn btn-primary'>
        Button
      </button>
      <button className='bg-primary'>Primary</button>
      <Button variant='destructive'>ShadcnButton</Button>
      <Button onClick={() => alert('xx')} variant='primary' size='sm'>
        ShadcnButton
      </Button>
    </>
  );
}
