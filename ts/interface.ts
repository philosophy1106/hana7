type Xid = { id: number };
type Xname = { name: string };
type Xage = { age: number };
type X = Xname | Xage;
type Y = Xname & Xage;
type Z = string & number;

type P = Xid | (Xname & Xage); // a + bc
type Q = Xid & (Xname | Xage); // ab + ac

let xx: X = { name: "Hong" };
xx = { age: 33 };

let yy: Y = { name: "Hong", age: 33 };

let pp: P = { id: 1 };
pp = { name: "Kim", age: 44 };
pp = { id: 1, name: "Kim", age: 44 };

let qq: Q = { id: 1, name: "Park" };
qq = { id: 2, age: 33 };

// type TT = { id: number; name?: string };
interface TT {
  readonly id: number;
  name?: string;
}
let tt: TT = { id: 1 };
// tt.id = 100;
tt.name?.toUpperCase();

//----------------------
interface CallSignature {
  (input: string): number; // call signa..
  count: 0; // cf. count: number
  greeting: (name: string) => void;
}

const typedCallSignature: CallSignature = (input) => input.length;

typedCallSignature.count = 0;
typedCallSignature.greeting = (name) => console.log(`Hi, ${name}`);

interface Novel {
  title: string; // 필수 속성 (실제 사용할 속성)
  [key: string]: string | number | boolean;
}

type User = {
  id: number;
  name: string;
};

// interface User {
//   addr: string;
// }

type BoardUser = User & { addr: string };

declare global {
  // interface console {
  //   bulb: (s: string) => string;
  // }
  interface Array<T> {
    // Array interface 병합
    first(): T;
    mapBy: (prop: string) => any;
  }
}

Array.prototype.mapBy = function (prop: string) {
  return this.map((a) => a[prop]);
};

const users = [
  { id: 1, name: "Hong" },
  { id: 2, name: "Kim" },
];
console.log("mapBy=", users.mapBy("name")); // ['Hong', 'Kim']

export {};
