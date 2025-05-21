`use strict`;
const assert = require("assert");
//-------------------------------------------------------

const arr = [1, 2, 3, 4, 5];
const hong = { id: 1, name: "Hing" };
const kim = { id: 2, name: "Kim" };
const lee = { id: 3, name: "Lee" };
const users = [hong, lee, kim];

Object.defineProperty(Array.prototype, {
  firstObject: {
    get() {
      return this[0];
    },
    set(value) {
      this[0] = value;
    },
  },
  lastObject: {
    get() {
      return this.at(-1);
    },
    set(value) {
      this[this.length - 1] = value;
    },
  },
});

Array.prototype.mapBy = function (prop) {
  return this.map((a) => a[prop]);
};

assert.deepStrictEqual([arr.firstObject, arr.lastObject], [1, 5]);
assert.deepStrictEqual(users.mapBy("id"), [1, 3, 2]);
assert.deepStrictEqual(users.mapBy("name"), ["Hing", "Lee", "Kim"]);
assert.deepStrictEqual(users.filterBy("id", 2), [kim]);
assert.deepStrictEqual(users.filterBy("name", "i", true), [hong, kim]); // key, value일부, isInclude
assert.deepStrictEqual(users.rejectBy("id", 2), [hong, lee]);
assert.deepStrictEqual(users.rejectBy("name", "i", true), [lee]);

Array.prototype.findBy = function (prop, value) {
  return this.find((a) => a[prop] === value);
};
assert.deepStrictEqual(users.findBy("name", "Kim"), kim);

Array.prototype.sortBy = function (prop) {
  const [key, direction = "asc"] = prop.split(":");
  const sign = direction === "desc" ? -1 : 1;
  return this.sort((a, b) => (a > b ? 1 * sign : -1 * sign));
};
assert.deepStrictEqual(users.sortBy("name:desc"), [lee, kim, hong]);
assert.deepStrictEqual(users.sortBy("name"), [hong, kim, lee]);
assert.deepStrictEqual(users.firstObject, hong);
assert.deepStrictEqual(users.lastObject, lee);
users.firstObject = kim;
assert.deepStrictEqual(users.firstObject, kim);
users.lastObject = hong;
assert.deepStrictEqual(users.lastObject, hong);
