const isStringNumber = (value: unknown): value is [string, number] =>
  Array.isArray(value) &&
  typeof value[0] === "string" &&
  typeof value[0] === "number";
const f1 = (value: number | string | boolean | [string, number]) => {
  if (isStringNumber(value)) {
    console.log(value[0].toUpperCase(), value[1].toFixed());
  }
};

const constCart = {
  K: 1,
  Y: 2,
  Z: 3,
} as const;

type TS = 1 | 2 | 3;
type ConsCart = typeof constCart;
