import { useState } from "react";

export const useToggle = (defaultFlag: boolean = false) => {
  const [flag, setFlag] = useState(defaultFlag);

  const toggle = () => setFlag(!flag);
  return [flag, toggle] as const; //const 안 붙이면 array, const 붙이면 tuple
};
