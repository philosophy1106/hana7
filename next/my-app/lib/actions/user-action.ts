'use server';

import prisma from '../db';

export const getUsers = async () => prisma.user.findMany();

export const getUser = async (email: string) =>
  prisma.user.findUnique({
    where: {
      email, //email: email인데 key value 같으면 생략
    },
  });
