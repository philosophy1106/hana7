import { cookies, headers } from 'next/headers';
import { NextRequest, NextResponse } from 'next/server';

export async function GET(request: NextRequest) {
  //const { searchParams, host, port, protocol, hostname, pathname, basePath } =
  //request.nextUrl;

  const { host } = request.nextUrl;
  const reqCookies = await cookies();
  console.log('🚀 ~ GET ~ reqCookies:', reqCookies);

  const reqHeaders = new Headers(request.headers);
  console.log('🚀 ~ GET ~ reqHeaders:', reqHeaders);

  const nextHeaders = await headers();
  const userAgent = nextHeaders.get('user-agent');

  const res = NextResponse.json(
    {
      host,
    },
    {
      headers: { 'Custon-Cookie': userAgent!, 'Set-Cookie': 'sid-1123' },
    }
  );

  res.cookies.set('x', '1234');
  res.cookies.set('y', '4567');

  const dbPasswd = process.env.DB_PASSWD;
  const { DEV_X } = process.env;
  console.log('🚀 dbPasswd:', dbPasswd);
  console.log('🚀 DEV_X:', DEV_X);
  console.log('🚀 NEXT_PUBLIC_x:', process.env.NEXT_PUBLIC_X);
  console.log('🚀 NEXT_PUBLIC_URL:', process.env.NEXT_PUBLIC_URL);

  const expireDate = new Date(); //거의 안 씀
  expireDate.setTime(expireDate.getTime() + 24 * 60 * 1000);
  res.cookies.set('otherCookies', 'oo', {
    //maxAge: 300, // 86400
    httpOnly: true,
    path: '/',
    secure: false,
    expires: expireDate,
  });

  return res;
  /* 
  return NextResponse.json({
    id: 1,
    name: '홍길동',
    str: searchParams.get('str'),
    host,
    hostname,
    pathname,
    basePath,
    port,
    protocol,
  }); */
}

export function POST() {}
