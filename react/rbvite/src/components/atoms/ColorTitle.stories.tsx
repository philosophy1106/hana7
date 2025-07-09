import type { Meta, StoryObj } from "@storybook/react";
import ColorTitle from "./ColorTitle";

const meta: Meta = {
  title: "Atoms/ColorTitle",
  component: ColorTitle,
  tags: ["autodocs"],
};

type Story = StoryObj<typeof meta>;

export const GreenTitle: Story = {
  args: {
    color: "teal",
    size: "md",
    textAlign: "start",
    children: "Teal Title",
  },
};

export const PinkTitle: Story = {
  args: {
    color: "cornflowerblue",
    size: "lg",
    textAlign: "center",
    children: "cornflowerblue Title",
  },
};

export default meta;
