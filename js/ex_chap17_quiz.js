const assert = require("assert");

const total = { price: 45000, vat: 4500 };
console.log(fmt`주문합계: ${total.price}원`);
console.log(fmt`세액합계: ${total.vat}원`);

function fmt(txts, value) {
  console.log(txts, value);
  return `${txts[0]}${value.toLocaleString().padStart(8)}${txts[1]}`;
}

const upperToLower = (str) =>
  str.replace(/[A-Z]/g, (foundStr) => foundStr.toLowerCase());
const low = upperToLower("Senior Coding Learning JS");
console.log("🚀 ~ low:", low);
// ⇒ '*s*-enior *c*-oding *l*-earning *j*-*s*-'

//대문자를 소문자로 소문자를 대문자로 바꾸기기
function lowNUpper(foundStr) {
  if (foundStr === foundStr.toUpperCase()) {
    return foundStr.toLowerCase();
  }
  return foundStr.toUpperCase();
}
//콜백 함수가 다른 곳에서 쓰이는 거 아니면 굳이 사용 X
const swapCase = (str) => str.replace(/([A-Z]+)|([a-z]+)/g, lowNUpper);
const result = swapCase("Senior ab Coding Learning JS");
console.log("🚀 ~ result:", result);

//return;

const result2 = swapCase("Hanaro7 Class");
console.log("🚀 ~ result2:", result2);

assert.equal(
  swapCase("Senior Coding Learning JS"),
  "sENIOR cODING lEARNING js"
);
assert.equal(swapCase("Hanaro 4 Class"), "hANARO 4 cLASS");

//2. 전화번호를 정확한 형식으로 출력하는 함수를 작성하시오
//if문을 줄이면 좋을 것 가틈... -> 가독성이 떨어지진 않나...
// /abc/ => new RegExp(abc) 랑 가음
function telfmt(pnum) {
  const pleng = pnum.length;
  return pleng === 8
    ? pnum.replace(/(\d{4})/, "$1-")
    : pleng === 9
    ? pnum.replace(/(\d{2})(\d{3})(\d{4})/, "$1-$2-$3")
    : pleng === 10
    ? pnum.replace(/(\d{2,3})(\d{3,4})(\d{4})/, "$1-$2-$3") //지역번호는 02 제외 다 세 자리니까 02만 따로 처리해 주기
    : pleng === 11
    ? pnum.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3")
    : pnum.replace(/(\d{4})(\d{4})(\d{4})/, "$1-$2-$3");
}

const r1 = telfmt("0101234567"); // '010-123-4567' 3/3/4 10
console.log("🚀 ~ r1:", r1);
const r2 = telfmt("01012345678"); // '010-1234-5678' 3/4/4 11
console.log("🚀 ~ r2:", r2);
const r3 = telfmt("0212345678"); // '02-1234-5678' 2/4/4 10
console.log("🚀 ~ r3:", r3);
const r4 = telfmt("021234567"); // '02-123-4567' 2/3/4 9
console.log("🚀 ~ r4:", r4);
const r5 = telfmt("0331234567"); // '033-123-4567' 3/3/4 10
console.log("🚀 ~ r5:", r5);
const r6 = telfmt("15771577"); // '1577-1577' 4/4 8
console.log("🚀 ~ r6:", r6);
const r7 = telfmt("07012341234"); // '070-1234-1234' 3/4/4 11
console.log("🚀 ~ r7:", r7);
