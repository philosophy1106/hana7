const n = 1;
const b = true;
const nb = n + b; //크기가 다른 것끼리 연산 불가지만 형변환으로 true가 1이 돼서 1 + 1 = 2
console.log("🚀 ~ nb:", nb);

const nil = null;
const n_nil = n + nil;
console.log("🚀 ~ n_nil:", n_nil); //null이 0으로 바뀐 것

const undef = undefined;
const n_undef = n + undef;
console.log("🚀 ~ n_undef:", n_undef);
console.log('+"" = ', +"");
console.log("+undefined = ", +undefined);

let x = 5;
console.log(3 - -x); // ? → , 10 / 0 ⇒⇒⇒ error?
console.log(10 + -x * 2); // ? →
console.log(-10 * -x * -2); // ? →
console.log((-10 / -x) * -2); // -1 or -4 →
console.log(2 ** (3 ** 2)); // 64(82) or 512(29) ?
console.log(x++, ++x); // ? → cf. log: function(x, y, …z)

const xxx = ++x;
console.log("🚀 ~ xxx:", xxx);

console.log("--------------------------------------");
let aa = 1;
let bb = 2;
let cc = (aa++, bb++, 5);
let dd = (aa--, bb + aa);
console.log(aa, bb, cc, dd);
