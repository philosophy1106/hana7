const testCar = {
  name: "benz",
  getName: function () {
    console.log("getName", this.length);
    const innerFunc1 = function () {
      console.log("innerFunc", this.length);
    };
    const innerFunc2 = () => {
      console.log("innerFuncc", this.length);
    };
    innerFunc1();
    innerFunc2();
  },
};

testCar.getName();
