//import { Outlet } from "react-router-dom";

import { Outlet, useOutletContext, useParams } from "react-router-dom";
import { useSession, type Cart } from "../contexts/session/SessionContext";

export default function ItemDetailLayout() {
  const {
    session: { cart },
  } = useSession();
  const { curItem } = useOutletContext<{ curItem: Cart }>();
  const { id } = useParams();

  let item = curItem;
  if (!curItem) {
    item = cart.find((_item) => _item.id === Number(id))!;
  }

  if (!item) {
    return <NotFoundItem id={id} />;
  }

  return (
    <>
      <h3>DetailLayout(사품명): {item.name}</h3>
      <div>
        <Outlet context={{ curItem: item }} />
      </div>
    </>
  );
}

function NotFoundItem({ id }: { id: string | undefined }) {
  return <h2>{id}번 상품을 찾을 수 없습니다!</h2>;
}
