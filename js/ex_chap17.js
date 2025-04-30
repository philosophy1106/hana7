//정규식.test(str)
//str.match(정규식)

const str = "Senior Coding Learning JS";
const a = /[A-z\d]/.test(str); // tr
console.log("🚀 ~ a:", a);
const b = /(A-z\d)/.test(str); // ?
console.log("🚀 ~ b:", b);
const c = /(A-z\d)/.test("XA-z2"); // ?
console.log("🚀 ~ c:", c);
const d = /(A-z\d)/.test("XAz2"); // ?
console.log("🚀 ~ d:", d);

const r1 = str.replace(/[A-Z]/g, "@");
console.log("🚀 ~ r1:", r1);

const regexp1 = /[A-Z]/g;
const rep1 = new RegExp("[A-Z]", "g");

function xx(...args) {
  console.log("xxx>>", ...args);
}
const star = "Senior Coding Learning JS".replace(
  /[A-Z]/,
  (foundStr, position) => {
    if (foundStr === "L") return "X" + position;
    return foundStr.toLowerCase() + position;
  }
);
console.log("🚀 ~ star:", star);
