import type { RefObject } from "react";
import Profile from "./Profile";
type Props = {
  logoutButtonRef: RefObject<HTMLButtonElement | null>;
};

//type Post = { id: number; title: string };

//const POSTS_URL = "https://jsonplaceholder.typicode.com/posts?userId=1";

export default function My({ logoutButtonRef }: Props) {
  return (
    <>
      <Profile logoutButtonRef={logoutButtonRef} />
    </>
  );
}
