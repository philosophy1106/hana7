import { notFound } from 'next/navigation';
import { NextResponse } from 'next/server';
import { FolderParams, folders, posts } from '../folderdata';

export async function GET(_req: Request, { params }: FolderParams) {
  const { folderId } = await params;
  const post = posts.find((f) => f.id === +folderId);
  if (!post) return notFound();

  return Response.json(post);
}

export async function PATCH(req: Request, { params }: FolderParams) {
  const { folderId } = await params;
  const folder = folders.find((f) => f.id === +folderId);
  if (!folder) return notFound();

  const { title } = await req.json();
  folder.title = title;
  return NextResponse.json(folder);
}

export async function DELETE(req: Request, { params }: FolderParams) {
  const { folderId } = await params;
  const idx = folders.findIndex((f) => f.id === +folderId);
  if (idx === -1) return notFound();
  folders.splice(idx, 1);
  return NextResponse.json({ msg: 'OK' });
}
