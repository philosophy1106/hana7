// __mocks__/next-auth.ts
export default function NextAuth(options: any) {
  return async function handler(req: any, res: any) {
    res.status(200).json({ mocked: true });
  };
}
