//5.
const prices = [10.34, "xxx", 5.678, null, 20.9, 1.005, 0, 15, undefined, 0.5];
let cnt = 0;
let sum = 0;
const p = 10 ** 15;

for (let i = 0; i < prices.length; i += 1) {
  //for(const n of prices)
  if (prices[i] === null || isNaN(prices[i])) continue;
  cnt += 1;
  sum += Math.trunc(prices[i] * p); //Math.trunc <= 넣기 14.9999 라도 15랑 큰 오차 없어서 맞게 나옴옴
  //console.log(prices[i] * p);
}
//const avg = (sum / (cnt * p)).toFixed(2);
let avg = (sum / (cnt * p)).toString();

console.log("avg: ", avg.substring(0, avg.indexOf(".") + 3));

return;

//4.
console.log("quiz 4 ---------------");
function addPoints(n, m) {
  //n과 m의 자리 수 구하기
  var deci = 0;
  const n1 = n.toString();
  const n2 = n.toString();
  const n1_len = n1.substring(n1.indexOf(".") + 1).length;
  const n2_len = n2.substring(n2.indexOf(".") + 1).length;
  n1_len > n2_len ? (deci = n1_len) : (deci = n2_len);
  const sum = n + m;
  console.log(sum.toFixed(deci));
}

addPoints(0.14, 0.28);
addPoints(0.21354, 0.1);

//return;

//3.
console.log("quiz 3 ---------------");
const today = new Date();
const WEEK_NAMES = "일월화수목금토";
console.log(`오늘은 ${WEEK_NAMES[today.getDay()]}요일입니다.`);

//2.
console.log("quiz 2 ---------------");
for (let i = 1; i <= 10; i++) {
  const num = Math.sqrt(i);
  if (!Number.isInteger(num)) {
    console.log(i, num.toFixed(3));
  }
}

//1.
console.log("quiz 1 ---------------");
for (let i = 1; i <= 10; i++) {
  console.log(i / 10);
}
