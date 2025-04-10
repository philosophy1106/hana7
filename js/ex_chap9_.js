//연습문제 1. 재귀함수수
function makeArray(n) {
  if (n === 1) return [1];
  return [...makeArray(n - 1), n];
}

function makeReverseArray(n) {
  if (n === 1) return [1];
  return [n, ...makeReverseArray(n - 1)];
}

const ma10 = makeArray(10);
console.log("🚀 ~ ma10:", ma10);

const ma5 = makeReverseArray(5);
console.log("🚀 ~ ma5:", ma5);

function makeArrayTCO(n, acc = []) {
  if (n === 1) return [1, ...acc];
  return makeArrayTCO(n - 1, [...acc, n]);
}

//연습문제 2. 피보나치치

function loopFibonacci(n) {
  if (n <= 1) return n;
  let prev = 0;
  let curr = 1;
  for (let i = 2; i <= n; i += 1) {
    let t = prev;
    prev = curr;
    curr = t + curr;
    // [prev, curr] = [curr, prev + curr];
  }

  return curr;
}

function recurFibonacci(n) {
  if (n === 1 || n === 0) return n;
  return recurFibonacci(n - 2) + recurFibonacci(n - 1);
}

function memoFibonacci(n) {
  const memoizedTable = {};
  if (n === 1 || n === 0) return n;
  return (
    memoizedTable[n] ||
    (memoizedTable[n] = memoFibonacci(n - 2) + memoFibonacci(n - 1))
  );
}

console.log("🚀 ~ loopFibonacci:", loopFibonacci(5));
console.log("🚀 ~ recurFibonacci:", recurFibonacci(7));
console.log("🚀 ~ memoFibonacci:", memoFibonacci(30));
