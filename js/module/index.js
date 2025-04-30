//const assert = require("assert"); //CommonJS 방식
import assert from "assert"; //라이브러리에서 가져온 것
import moment from "moment";
//import { aaf } from "aa.js";
const hello = "Hello module";
assert.equal(hello, "Hello module");
console.log("🚀 ~ hello:", hello, moment().startOf("day").fromNow());
assert.equal(hello, "Hello Module");

//const aa = aaf();
//console.log("🚀 ~ aa:", aa);
