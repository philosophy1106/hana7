var x;
x = 100;
var y;

console.log(zz);

zz = 9;
console.log(zz);
console.log(globalThis(["zz"])); //node에선 전역 객체를 global browser에선 window

var zz;
console.log(this);
console.log(globalThis);
