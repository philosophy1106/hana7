const readline = require("readline");
const { stdin: input, stdout: output } = require("process");

const rl = readline.createInterface({ input, output });
console.log("\n".repeat(1));

const gener = add();
const { value } = gener.next();
console.log(value);

rl.on("line", (answer) => {
  console.log("line.answer>>", answer);
  const { value, done } = gener.next(Number(answer));
  console.log(value);
  if (answer === "bye") rl.close();
}).on("close", () => {
  process.exit();
});

function* add() {
  const a = yield "first number";
  const b = yield "second number";
  return a + b;
}

//----------------------------------------------------------------
