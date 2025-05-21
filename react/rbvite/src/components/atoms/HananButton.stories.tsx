import { type Meta, type StoryObj } from "@storybook/react";
import HanaButton from "./HananButton";

const meta: Meta = {
  title: "HanaButton",
  component: HanaButton,
  tags: ["autodocs"],
};

type Story = StoryObj<typeof meta>;

export const PrimaryButton: Story = {
  args: {
    variant: "primary",
    size: "md",
    children: "PRIME",
    onClick: () => alert("primary!!"),
  },
};

export const DangerButton: Story = {
  args: {
    variant: "danger",
    size: "lg",
    children: "DANGER",
    onClick: () => alert("danger!!"),
  },
};

export default meta;
