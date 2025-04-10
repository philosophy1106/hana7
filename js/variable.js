const n = 123; //8B
const bi = 123n; //16B

const n__bi = n === bi;
console.log("🚀 ~ n__bi:", n__bi); //ctrl alt L

const n_bi = n == bi;
console.log("🚀 ~ n_bi:", n_bi);

const nAddbi = BigInt(n) + bi;
console.log("🚀 nAddbi:", nAddbi, typeof nAddbi);

const s = "abc";
const ss = new String("abc");

const s__ss = s == ss;
console.log("🚀 ~ s__ss:", s__ss, typeof s);

const s___ss = s === ss;
console.log("🚀 ~ s___ss:", s___ss, typeof ss);

const sNum = Number(s);
console.log("🚀 ~ sNum:", sNum);
const ssNumber = Number(ss);
console.log("🚀 ~ ssNumber:", ssNumber);
console.log("Number(s) == Number(ss)", Number(s) == Number(ss), isNaN(sNum));

const sss = `${s} - ${n + Number(bi)}`;
console.log("🚀 ~ sss:", sss);

console.log("---------------------------");
const s1 = Symbol("foo");
const s2 = Symbol("foo");
const s2__s1 = s1 == s2;
console.log("🚀 ~ s2__s1:", s2__s1);

const seoulHong = Symbol.for("H"); //key를 주는 것
const busanHong = Symbol.for("H");
const s_b = seoulHong == busanHong;
console.log("🚀 ~ s_b:", s_b);

const undef = undefined;
const nil = null;
const undef_nil = undef == null;
const undef__nil = undef === null;
console.log("🚀 ~ undef_nil:", undef_nil);
console.log("🚀 ~ undef__nil:", undef__nil);

const hong = { id: 1, name: "Hong" };
let kim = { id: Symbol(), neme: "Kim" };
console.log(hong === kim);
kim = hong;
console.log(hong === kim);
const o1 = new Object();
const o2 = {};
console.log("o1===o2", o1 === o2);

const nStr = n.toString();
const nStr2 = new Number(n).toString();
console.log("🚀 ~ nStr:", nStr, nStr2, typeof n);

const nStr16 = n.toString(16);
console.log("🚀 ~ nStr16:", nStr16);

const nStr16d = parseInt(nStr16, 16);
console.log("🚀 ~ nStr16d:", nStr16d);

console.log("---------------------------");
const d1 = Date();
const d2 = new Date();
console.log(d1 == d2);
