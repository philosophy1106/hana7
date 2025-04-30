interface IUser {
  id: number;
  age: number;
  name: string;
}

interface IDept {
  id: number;
  age: string;
  dname: string;
  captain: string;
}

// type Combine2<T, U> = {
//     [k in keyof (T& U)]: k extends keyof T & keyof U ? T[k] | U[k] : k extends keyof T  ? T[k] : U[k];
// };

type Combine2<T, U> = {
  [k in keyof (T & U)]: k extends keyof T & keyof U ? T[k] | U[k] : (T & U)[k];
};

type ICombined = Combine2<IUser, IDept>;

let combineX: ICombined = {
  id: 0,
  age: 33,
  name: "aaa",
  dname: "bbb",
  captain: "ccc",
};
let combineY: ICombined = {
  id: 0,
  age: "33세",
  name: "aaa",
  dname: "bbb",
  captain: "ccc",
};

type ArrayItems<T> = T extends (infer X)[] ? X : T;

type StringItem = ArrayItems<number>; // string
type StringArrayItem = ArrayItems<string[]>; // string
type NumberArrayItem = ArrayItems<number[]>; // number
type BooleanArrayItem = ArrayItems<boolean[]>; // boolean
type StringArrayItem2 = ArrayItems<Array<string>>; // string[] ⇒ string
type String2DItem = ArrayItems<string[][]>; // string[]

type ArrayItems2<T, X> = T extends (infer X)[] ? X : T;
type StringArrayItem22 = ArrayItems2<string[], number>; // string
type StringArrayItem23 = ArrayItems2<string, number>; // string

type Excludex<T, U> = T extends U ? never : T;
type Ee = Exclude<string | number, string>;
type Ex = Excludex<string | number | boolean, string | boolean>;

type Berry = `${string}berry`;
const x1: Berry = "Strawberry";
const x2: Berry = "blueberry";
const x3: Berry = "cloudberry";
const x4: Berry = "blackberry";
const page: `Page.${number}` = "Page.1";

type ItemPrice = Record<string, number>;
