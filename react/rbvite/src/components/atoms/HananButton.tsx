import type { CSSProperties, PropsWithChildren } from "react";

type Props = {
  size: "sm" | "md" | "lg";
  variant: "default" | "primary" | "danger";
  onClick?: () => void;
};

const variantStyle: Record<Props["variant"], CSSProperties> = {
  default: { backgroundColor: "white", color: "gray" },
  primary: { backgroundColor: "blue", color: "white" },
  danger: { backgroundColor: "red", color: "white" },
};

const sizetyle = {
  sm: { padding: "0.1rem" },
  md: { padding: "1rem" },
  lg: { padding: "1.5rem", fontSize: "1.5rem" },
};

export default function HanaButton({
  variant,
  children,
  size,
  onClick = () => {},
}: PropsWithChildren<Props>) {
  const style = Object.assign({}, variantStyle[variant], sizetyle[size]);
  return (
    <button onClick={onClick} style={style}>
      {children}
    </button>
  );
}
