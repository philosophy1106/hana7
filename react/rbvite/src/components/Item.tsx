import { useEffect, useRef, useState, type FormEvent } from "react";
import { useSession } from "../contexts/session/SessionContext";
import { useParams } from "react-router-dom";

type Props = {
  toggleAdding?: () => void; //toggle 은 on, off 스위치 개념념a
  addExpectPrice?: (price: number) => void;
};

export default function Item({ addExpectPrice, toggleAdding }: Props) {
  const {
    session: { cart },
  } = useSession();
  const param = useParams();
  const item = cart.find((item) => item.id === Number(param.id)) || {
    id: 0,
    name: "",
    price: 3000,
  };

  const { removeItem, addItem, editItem } = useSession();
  const [isEditing, setEditing] = useState(!item.id);
  const [hasDirty, setDirty] = useState(false);

  const itemNameRef = useRef<HTMLInputElement>(null);
  const itemPriceRef = useRef<HTMLInputElement>(null);

  const submitItem = (evt: FormEvent<HTMLFormElement>) => {
    evt.preventDefault();
    const name = itemNameRef.current?.value;
    const price = itemPriceRef.current?.value;
    if (!name) {
      alert("상품명을 입력하세요!");
      itemNameRef.current?.focus();
      return;
    }

    if (!price) {
      alert("금액을 입력하세요!");
      itemPriceRef.current?.focus();
      return;
    }

    const { id } = item;
    if (id) {
      editItem({ id, name, price: +price });
    } else {
      addItem(name, +price);
      if (toggleAdding) toggleAdding();
    }

    setEditing(false);
  };

  const resetItem = () => {
    setEditing(false);
    setDirty(false);
    if (toggleAdding) toggleAdding();
    if (!item.id && itemPriceRef.current && addExpectPrice) addExpectPrice(0);
  };

  const checkDirty = () => {
    setDirty(
      itemNameRef.current?.value !== item.name ||
        Number(itemPriceRef.current?.value) !== item.price
    );
  };

  useEffect(() => {
    if (!item.id && addExpectPrice) addExpectPrice(item.price);
  }, []);

  return (
    <>
      {isEditing ? (
        <form onSubmit={submitItem} onReset={resetItem}>
          <input
            type="text"
            ref={itemNameRef}
            defaultValue={item.name}
            className="w-sm"
            placeholder="상품명..."
            onChange={checkDirty}
          />
          <input
            type="number"
            ref={itemPriceRef}
            placeholder="금액..."
            className="w-sm"
            onChange={(evt) => {
              checkDirty();
              if (!item.id && addExpectPrice)
                addExpectPrice(item.id ? 0 : Number(evt.target.value));
            }}
          />
          <button type="reset" className="p-sm">
            취소
          </button>
          <button type="submit" className="p-sm" disabled={!hasDirty}>
            ✔️ {item.id ? "수정" : "추가"}
          </button>
        </form>
      ) : (
        <div>
          <a href="#" onClick={() => setEditing(!isEditing)}>
            {item.id}. {item.name} ({item.price.toLocaleString()})
          </a>
          <button onClick={() => removeItem(item.id)} className="p-sm">
            x
          </button>
        </div>
      )}
    </>
  );
}
