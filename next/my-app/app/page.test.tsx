import { render, screen } from '@testing-library/react';
import Home from './page';

test('page', async () => {
  render(await Home());

  expect(
    screen.getByRole('heading', { level: 1, name: 'Global Page:' })
  ).toBeDefined();

  expect(screen.getByText(/Global Page/i)).toBeInTheDocument();
});
