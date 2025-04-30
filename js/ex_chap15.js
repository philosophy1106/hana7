const hong = { id: 1, name: "Hong" };
const m = new Map();
m.set(1, 100);
m.set(2, 200);
m.set(hong, hong.name);
m.set(2, 222); //덮어씀

console.log("🚀 ~ m:", m, m.has(hong), m.get(2));

const s = new Set([1, 2, "3"]);
s.add(4);
s.add(hong);
console.log("🚀 ~ s:", s, s.has(hong), [...s]);
