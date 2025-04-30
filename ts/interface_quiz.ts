import assert = require("assert");


interface User {
  id: number;
  name: string;
}

interface Dept {
  id: number;
  dname: string;
  captain: string;
}
interface Ud2 {
  id: number;  //사실 안 써도 오류 X 벗... 그래도 디테일할수록 좋으 
  [x: string]: number | string;
  addr: string;
}

// 다음 코드가 오류가 없으면 통과!
const ud2: Ud2 = { id: 1, name: "HH", addr: "Seoul" };
const ud3: Ud2 = { id: 1, dname: "HH", captain: "HH", addr: "Seoul" };




type prop = string | number | symbol;

declare global{
    interface Array<T>{
        firstObject: T;
        lastObject: T;
        mapBy: (prop: Prop) => any;
        filterBy: (prop: Prop,value: unknown, isInclude? );
    }
}

