import { useId } from "react";

export default function LabelInput({ label }: { label: string }) {
  const id = useId(); //중복 안 되게 아이디 줌?
  return (
    <label htmlFor={id}>
      {label}: <input type="text" id={id} />
    </label>
  );
}
