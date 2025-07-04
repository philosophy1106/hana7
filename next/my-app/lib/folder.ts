'use server';

export type Folder = { id: number; title: string };
const Folders = [
  { id: 1, title: 'JS' },
  { id: 2, title: 'TS' },
  { id: 3, title: 'Next' },
  { id: 4, title: 'etc' },
];

export const getFolders = async (): Promise<Folder[]> =>
  new Promise((resolve) => setTimeout(() => resolve(Folders), 500));
