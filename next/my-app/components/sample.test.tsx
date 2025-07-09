// components/sample.test.tsx
import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import { useRef } from 'react';
import { Button } from './ui/button';
import { Input } from './ui/input';

function Hello({ f }: { f: (email?: string) => void }) {
  const emailRef = useRef<HTMLInputElement>(null);

  return (
    <>
      <h1>Hello Vitest!</h1>
      <Input type='email' ref={emailRef} placeholder='email...' />
      <Button onClick={() => f(emailRef.current?.value)}>Action</Button>
    </>
  );
}

test('Hello Test', async () => {
  const user = userEvent.setup();
  const f = vi.fn(); //가상의 함수가 됨?
  render(<Hello f={f} />);
  expect(screen.getByText(/Hello/i)).toBeInTheDocument();
  const inpEmail = screen.getByPlaceholderText('email...');
  await user.type(inpEmail, 'test@example.com');
  const btn = screen.getByRole('button', { name: 'Action' });
  await user.click(btn);
  expect(f).toHaveBeenCalledTimes(1);
  expect(f).toHaveBeenCalledWith('test@example.com');
});
