//import { describe, expect, it } from 'vitest';
import { sum } from '../lib/actions/calc';

describe('calc-sum', () => {
  it('sum(0)', () => {
    expect(sum(0)).toBe(0);
  });

  it('sum(10) and sum(100)', () => {
    expect(sum(10)).toBe(10);
    expect(sum(100)).toBe(100);
  });
});
